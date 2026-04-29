package org.kareem.springcloud.couponservice.repository;

import org.kareem.springcloud.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    Coupon findByCode(String code);
}
