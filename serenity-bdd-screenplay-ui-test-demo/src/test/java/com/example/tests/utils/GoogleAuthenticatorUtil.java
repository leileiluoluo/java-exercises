package com.example.tests.utils;

import com.warrenstrange.googleauth.GoogleAuthenticator;

public class GoogleAuthenticatorUtil {

    private static final GoogleAuthenticator authenticator = new GoogleAuthenticator();

    public static int getTotpCode(String secret) {
        return authenticator.getTotpPassword(secret);
    }

}
