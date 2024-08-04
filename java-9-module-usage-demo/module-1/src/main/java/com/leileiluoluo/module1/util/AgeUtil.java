package com.leileiluoluo.module1.util;

public class AgeUtil {

    public static String getAgeGroup(int age) {
        if (age >= 0 && age < 18) {
            return "未成年";
        } else if (age < 45) {
            return "青年";
        } else if (age < 60) {
            return "中年";
        } else {
            return "老年";
        }
    }

}
