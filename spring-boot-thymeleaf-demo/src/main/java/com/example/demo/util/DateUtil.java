package com.example.demo.util;

import java.time.LocalDate;

public class DateUtil {

    public static int getCurrentYear() {
        return LocalDate.now().getYear();
    }

}
