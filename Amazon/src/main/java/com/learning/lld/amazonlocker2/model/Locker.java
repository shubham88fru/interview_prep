package com.learning.lld.amazonlocker2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Locker {
    private String id;
    private LockerSize lockerSize;
    private String locationId;
    private LockerStatus lockerStatus;

    public Locker(LockerSize lockerSize, String locationId) {
        id = UUID.randomUUID().toString();
        this.lockerSize = lockerSize;
        this.locationId = locationId;
        this.lockerStatus = LockerStatus.AVAILABLE;
    }
}
