package com.learning.lld.amazonlocker2.service;

import com.learning.lld.amazonlocker2.model.LockerPackage;
import com.learning.lld.amazonlocker2.model.Notification;
import com.learning.lld.amazonlocker2.repository.NotificationRepository;

public class NotificationService {
    CustomerService customerService = new CustomerService();

    public void notifyCustomerOrder(LockerPackage lockerPackage) {
        String customerId = customerService.getCustomerIdForOrder(lockerPackage.getOrderId());
        Notification notification = new Notification(customerId, lockerPackage.getOrderId(),
                lockerPackage.getLockerId(), lockerPackage.getCode());
        NotificationRepository.notificationMap.put(lockerPackage.getOrderId(), notification);
        System.out.printf("Customer %s notified for order %s " +
                        " in locker %s with pin %s", customerId,
                lockerPackage.getOrderId(),
                lockerPackage.getLockerId(),
                lockerPackage.getCode()
        );

    }
}