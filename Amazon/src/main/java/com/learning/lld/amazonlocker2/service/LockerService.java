package com.learning.lld.amazonlocker2.service;

import com.learning.lld.amazonlocker2.model.*;
import com.learning.lld.amazonlocker2.repository.LockerLocationRepository;
import com.learning.lld.amazonlocker2.repository.LockerPackageRepository;
import com.learning.lld.amazonlocker2.repository.LockerRepository;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class LockerService {

    public Locker findLockerIbyId(String id) {
        return LockerRepository.lockerMap.get(id);
    }

    public Locker getLocker(LockerSize lockerSize, GeoLocation geoLocation) {
        return getAvailableLocker(lockerSize, geoLocation);
    }

    public void pickFromLocker(String lockerId,
                               String code, LocalDateTime localDateTime) throws
            Exception {
        Optional<LockerPackage> lockerPackage =
                LockerPackageRepository.getLockerByLockerId(lockerId);
        if (!lockerPackage.isPresent())
            throw new Exception("Locker with code not found");

        //req: open the door only when valid code
        //is entered corresponding to the package inside
        //the locker.
        if (!lockerPackage.get().verifyCode(code))
            throw new Exception("Locker code mismatch");

        //req: code should not have expired.
        if (!lockerPackage.get().isValidCode(localDateTime)) {
            throw new Exception("Pickup code expired");
        }
        Locker locker = LockerRepository.lockerMap.get(lockerId);

        //req: timing of locker location.
        if (canPickFromLocker(lockerId, localDateTime)) {
            locker.setLockerStatus(LockerStatus.AVAILABLE);
            lockerPackage.get().setCode(null);
        } else {
            lockerPackage.get().setCode(null);
            throw new Exception("Package not picked for x days");
        }
    }

    private Locker getAvailableLocker(LockerSize lockerSize,
                                      GeoLocation geoLocation) {
        return checkAndGetAvailableLockers(lockerSize, geoLocation);
    }

    private Locker checkAndGetAvailableLockers(LockerSize lockerSize,
                                               GeoLocation geoLocation) {
        Locker locker = LockerRepository.getLocker(lockerSize, geoLocation);
        locker.setLockerStatus(LockerStatus.BOOKED);
        return locker;
    }

    private boolean canPickFromLocker(String lockerId, LocalDateTime localDateTime) {
        Locker locker = LockerRepository.lockerMap.get(lockerId);
        LockerLocation lockerLocation = LockerLocationRepository.getLockerInLocation(locker.getLocationId());
        LocationTiming locationTiming = lockerLocation.getLocationTiming();
        Timing timing = locationTiming.getTimingMap().get(localDateTime.getDayOfWeek());
        Time currentTime = Time.valueOf(getTimeFromDate(localDateTime));
        if (currentTime.after(timing.getOpenTime()) && currentTime.before(timing.getCloseTime())) {
            return true;
        }
        return false;
    }

    private String getTimeFromDate(LocalDateTime localDateTime) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(new Date());
        return time;
    }
}