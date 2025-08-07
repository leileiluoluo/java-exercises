package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResult {

    private boolean success;
    private String message;

}
