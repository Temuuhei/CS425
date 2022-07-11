package finalexam.gdm.controller;

import finalexam.gdm.model.Supplier;
import finalexam.gdm.service.SupplierService;
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
@RequestMapping(value = {"/gdm/supplier"})
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @GetMapping(value = {"/list"})
    public ModelAndView listSuppliers(Model model) {
        var suppliers = supplierService.getAllSuppliers();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.setViewName("public/supplierlist");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewSupplierForm(Model model) {
        var newSupplier = new Supplier();
        model.addAttribute("supplier", newSupplier);
        return "public/newSupplier";
    }
    // Create Post
    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewSupplier(@Valid @ModelAttribute("supplier") Supplier supplier, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("supplier", supplier);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "public/newSupplier";
        }
        supplierService.addNewSupplier(supplier);
        return "redirect:/gdm/supplier/list";
    }
}
