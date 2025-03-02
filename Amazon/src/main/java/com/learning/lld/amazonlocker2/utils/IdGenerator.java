package com.learning.lld.amazonlocker2.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class IdGenerator {
    public static String generateId(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}