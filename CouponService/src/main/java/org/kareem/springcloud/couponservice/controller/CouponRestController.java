package org.kareem.springcloud.couponservice.controller;

import lombok.RequiredArgsConstructor;
import org.kareem.springcloud.couponservice.model.Coupon;
import org.kareem.springcloud.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
@RequiredArgsConstructor
public class CouponRestController {
    private final CouponRepository couponRepository;

    private final Environment env;
    /**
     *line 19 , in the tutorial instructor use `@RequestMapping(value = "/copons" , method = RequestMethod.POST`
     * */
    @PostMapping
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @GetMapping("/{code}")
    public Coupon getCoupon(@PathVariable String code){
        System.out.println("Server port: " + env.getProperty("local.server.port"));
        return couponRepository.findByCode(code);
    }
}
