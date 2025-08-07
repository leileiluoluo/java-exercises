package com.example.demo.factory;

import com.example.demo.enums.PaymentType;
import com.example.demo.service.PaymentService;
import com.example.demo.util.SpringContextHolder;

public class PaymentFactory {

    public static PaymentService getService(PaymentType paymentType) {
        String beanName = paymentType.name().toLowerCase() + "PaymentService";
        return SpringContextHolder.getBean(beanName, PaymentService.class);
    }

}
