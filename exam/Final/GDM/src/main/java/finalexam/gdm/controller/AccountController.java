package finalexam.gdm.controller;


import finalexam.gdm.model.Account;
import finalexam.gdm.service.AccountService;
import finalexam.gdm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/spebank/account"})
public class AccountController {

    @Autowired
    private AccountService accountService;
    private CustomerService customerService;

    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listAccounts(Model model) {
        var accounts = accountService.getAllAccounts();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("accounts", accounts);
        modelAndView.setViewName("public/accountlist");
        return modelAndView;
    }

    @GetMapping(value = {"/prime/list"})
    public ModelAndView listPrimeAccounts(Model model) {
        var accounts = accountService.getPrimeAccounts();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("accounts", accounts);
        modelAndView.setViewName("public/accountlist");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewAccountForm(Model model) {
        var customers = customerService.getAllCutomers();
        var newAccount = new Account();
        model.addAttribute("account", newAccount);
        model.addAttribute("customers", customers);
        return "public/newAccount";
    }
    // Create Post
    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewAccount(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("account", account);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "public/newAccount";
        }
        var newAcc = accountService.addNewAccount(account);
        System.out.println("new Account " + newAcc);
        return "redirect:/spebank/account/list";
    }
}
