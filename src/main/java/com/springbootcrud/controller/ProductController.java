package com.springbootcrud.controller;

import com.springbootcrud.entity.Product;
import com.springbootcrud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("")
    public String pageProduct(Model model){
        model.addAttribute("product",new Product());
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "product";
    }

    @PostMapping("/add")
    public String addProduct(
            @ModelAttribute(name = "product") Product product
    ){
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(
            @PathVariable(name = "id") Integer id
    ){
        productService.deleteById(id);
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(
            Model model,
            @PathVariable(name = "id") Integer id
    ){
        Product product = productService.findById(id).get();
        model.addAttribute("p",product);
        model.addAttribute("product",new Product());
        return "detailproduct";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(
            @ModelAttribute(name = "product") Product product,
            @PathVariable(name = "id") Integer id
    ){
        product.setId(id);
        productService.save(product);
        return "redirect:/product";
    }

}
