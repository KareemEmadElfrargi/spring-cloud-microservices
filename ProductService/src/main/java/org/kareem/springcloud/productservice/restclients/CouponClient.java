package org.kareem.springcloud.productservice.restclients;

import org.kareem.springcloud.productservice.model.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("coupon-service")
public interface CouponClient {

    @GetMapping("/couponapi/{code}")
    public Coupon getCoupon(@PathVariable String code);

}
