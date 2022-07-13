package finalexam.gdm.controller;

import finalexam.gdm.model.Customer;
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
@RequestMapping(value = {"/spebank/customer"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(value = {"/list"})
    public ModelAndView listCustomers(Model model) {
        var customers = customerService.getAllCutomers();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customers);
        modelAndView.setViewName("public/customerlist");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewCustomerForm(Model model) {
        var newCustomer = new Customer();
        model.addAttribute("customer", newCustomer);
        return "public/newCustomer";
    }
    // Create Post
    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewCustomer(@Valid @ModelAttribute("supplier") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "newCustomer";
        }
        customerService.addNewCustomer(customer);
        return "redirect:/spebank/customer/list";
    }
}
