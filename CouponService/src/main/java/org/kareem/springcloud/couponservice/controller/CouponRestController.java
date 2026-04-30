package org.kareem.springcloud.couponservice.controller;

import lombok.RequiredArgsConstructor;
import org.kareem.springcloud.couponservice.model.Coupon;
import org.kareem.springcloud.couponservice.repository.CouponRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
@RequiredArgsConstructor
public class CouponRestController {
    private final CouponRepository couponRepository;

    /**
     *line 19 , in the tutorial instructor use `@RequestMapping(value = "/copons" , method = RequestMethod.POST`
     * */
    @PostMapping
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @GetMapping("/{code}")
    public Coupon getById(@PathVariable String code){
        return couponRepository.findByCode(code);
    }
}
