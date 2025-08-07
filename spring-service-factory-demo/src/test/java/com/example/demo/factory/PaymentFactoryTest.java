package com.example.demo.factory;

import com.example.demo.enums.PaymentType;
import com.example.demo.model.Order;
import com.example.demo.model.PaymentResult;
import com.example.demo.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentFactoryTest {

    @Test
    public void testGetService() {
        PaymentService paymentService = PaymentFactory.getService(PaymentType.WECHAT);
        PaymentResult paymentResult = paymentService.pay(new Order());

        System.out.println(paymentResult);
    }

}
