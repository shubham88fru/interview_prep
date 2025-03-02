package com.learning.lld.amazonlocker2.service;

import com.learning.lld.amazonlocker2.model.*;
import com.learning.lld.amazonlocker2.repository.LockerPackageRepository;
import com.learning.lld.amazonlocker2.utils.IdGenerator;
import com.learning.lld.amazonlocker2.utils.SizeUtils;

import java.util.List;

public class DeliveryService {
    NotificationService notificationService = new NotificationService();
    OrderService orderService = new OrderService();
    LockerService lockerService = new LockerService();

    public void deliver(String orderId) throws Exception {
        Order order = orderService.getOrder(orderId);
        List<Item> items = order.getItems();
        com.learning.lld.amazonlocker2.model.Package pkg =
                new com.learning.lld.amazonlocker2.model.Package(orderId, items);

        //first determine the appropriate size locker that'll be needed.
        LockerSize lockerSize = SizeUtils.SizeUtil.getLockerSizeForPack(pkg.getPackageSize());

        //then use the service to get a locker of required size in the delivery location.
        Locker locker = lockerService.getLocker(lockerSize, order.getDeliveryGeoLocation());
        LockerPackage lockerPackage = new LockerPackage();
        lockerPackage.setCode(IdGenerator.generateId(6));
        lockerPackage.setOrderId(orderId);
        lockerPackage.setLockerId(locker.getId());
        LockerPackageRepository.lockerPackages.add(lockerPackage);
        locker.setLockerStatus(LockerStatus.CLOSED);
        notificationService.notifyCustomerOrder(lockerPackage);

    }
}
