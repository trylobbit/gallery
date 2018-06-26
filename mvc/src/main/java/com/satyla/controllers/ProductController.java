package com.satyla.controllers;

import com.satyla.model.Product;
import com.satyla.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/edit")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "edit";
    }

    @PostMapping("/edit")
    public String addProduct(@ModelAttribute Product product) {
        LOG.info("Success, Product added");
        productService.add(product);
        return "redirect:base";
    }

    @GetMapping("/update")
    public String updateForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model, @ModelAttribute Product product) {
        model.addAttribute("product", product);
        productService.updateProduct(id, product);
        return "redirect:/base";
    }


}