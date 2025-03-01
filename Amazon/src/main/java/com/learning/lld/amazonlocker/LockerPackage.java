package com.learning.lld.amazonlocker;

import java.util.Date;

public class LockerPackage extends Package {
    private int codeValidDays;
    private String lockerId;
    private String code;
    private Date deliveryTime;

    public boolean isCodeValid() {return false;}
    public boolean verifyCode(String code) {return false;}
}
