package com.eventostec.api.service;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.repositories.CouponRepository;
import com.eventostec.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO coupon){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new IllegalArgumentException("event not found"));

        Coupon newCoupon = new Coupon();
        newCoupon.setCode(coupon.code());
        newCoupon.setDiscount(coupon.discount());
        newCoupon.setValid(new Date(coupon.valid()));
        newCoupon.setEvent(event);

        return couponRepository.save(newCoupon);
    }

    public List<Coupon> consultCoupons(UUID eventId, Date currentDate){
        return couponRepository.findByEventIdAndValidAfter(eventId, currentDate);
    }
}
