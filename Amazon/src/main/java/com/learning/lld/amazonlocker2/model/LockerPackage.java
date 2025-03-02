package com.learning.lld.amazonlocker2.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class LockerPackage {
    final int codeValidDays = 3;
    private String lockerId;
    private String orderId;
    private String code;
    private LocalDateTime packageDeliveredTime;

    public boolean isValidCode(LocalDateTime currentTime) throws Exception {
        if (currentTime.compareTo(packageDeliveredTime) > codeValidDays) {
            throw new Exception("Pickup code expired");
        }
        return true;
    }

    public boolean verifyCode(String code) {
        return this.code.equals(code);
    }
}
