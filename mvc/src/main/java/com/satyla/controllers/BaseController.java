package com.satyla.controllers;

import com.satyla.currency.Rate;
import com.satyla.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BaseController {

    private final ProductService productService;

    @Autowired
    public BaseController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/base")
    public String getAllProducts(Model model, @RequestParam(required = false) String code) {
        model.addAttribute("rate", new Rate());
        model.addAttribute("code", code);
        model.addAttribute("allproducts", productService.getAllProducts(code));
        return "base";
    }

}