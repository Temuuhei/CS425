package finalexam.gdm.controller;


import finalexam.gdm.model.Product;
import finalexam.gdm.service.ProductService;
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
@RequestMapping(value = {"/gdm/product"})
public class ProductController {

    @Autowired
    private ProductService productService;
    private SupplierService supplierService;

    public ProductController(ProductService productService, SupplierService supplierService) {
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listSuppliers(Model model) {
        var products = productService.getAllProducts();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("public/productlist");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewproductForm(Model model) {
        var suppliers = supplierService.getAllSuppliers();
        var newProduct = new Product();
        Integer supplierId = 0;
        model.addAttribute("product", newProduct);
        model.addAttribute("suppliers", suppliers);
        return "public/newProduct";
    }
    // Create Post
    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "public/newProduct";
        }
        var newpro = productService.addNewProduct(product);
        System.out.println("new Product " + newpro);
        return "redirect:/gdm/product/list";
    }
}
