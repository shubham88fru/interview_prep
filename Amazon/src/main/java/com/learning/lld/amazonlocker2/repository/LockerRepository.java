package com.learning.lld.amazonlocker2.repository;

import com.learning.lld.amazonlocker2.model.GeoLocation;
import com.learning.lld.amazonlocker2.model.Locker;
import com.learning.lld.amazonlocker2.model.LockerSize;
import com.learning.lld.amazonlocker2.model.LockerStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LockerRepository {
    public static List<Locker> lockers;
    public static Map<String, Locker> lockerMap;

    static {
        lockers = new ArrayList<>();
        lockerMap = new HashMap<>();
    }

    public static Locker getLocker(LockerSize lockerSize, GeoLocation geoLocation) {

        //assuming some service will give us all lockers in a location.

        //then on the `lockers` we get from above step, find available lockers or desired size.
        List<Locker> lockerList
                = lockers.stream()
                .filter(locker -> locker.getLockerStatus() == LockerStatus.AVAILABLE && locker.getLockerSize() == lockerSize)
                .toList();

        if (!lockerList.isEmpty()) {
            return lockerList.get(0);
        }

        return null;
    }
}
