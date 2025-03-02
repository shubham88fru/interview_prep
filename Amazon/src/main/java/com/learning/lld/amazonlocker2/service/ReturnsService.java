package com.learning.lld.amazonlocker2.service;

import com.learning.lld.amazonlocker2.model.Item;
import com.learning.lld.amazonlocker2.model.Locker;
import com.learning.lld.amazonlocker2.model.LockerStatus;

public class ReturnsService {

    public void returnItemsToLocker(Item item, Locker locker) {
        locker.setLockerStatus(LockerStatus.CLOSED);
    }

}