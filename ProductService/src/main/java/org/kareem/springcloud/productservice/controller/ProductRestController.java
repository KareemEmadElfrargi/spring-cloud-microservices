package org.kareem.springcloud.productservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.kareem.springcloud.productservice.model.Coupon;
import org.kareem.springcloud.productservice.model.Product;
import org.kareem.springcloud.productservice.repository.ProductRepository;
import org.kareem.springcloud.productservice.restclients.CouponClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productapi")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductRepository productRepository;

    private final CouponClient couponClient;

    @PostMapping()
    @Retry(name = "product_api")
    public Product create(@RequestBody Product product) {
        Coupon coupon = couponClient.getCoupon(product.getCouponCode());
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }
    @GetMapping()
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

}
