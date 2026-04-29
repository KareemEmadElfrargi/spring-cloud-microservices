package org.kareem.springcloud.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.kareem.springcloud.productservice.model.Product;
import org.kareem.springcloud.productservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productapi")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductRepository productRepository;

    @PostMapping()
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }
    @GetMapping()
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

}
