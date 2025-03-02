package com.learning.lld.amazonlocker2.repository;

import com.learning.lld.amazonlocker2.model.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    public static Map<String, Order> ordersMap = new HashMap<>();
    public static Order getOrder(String orderId) {
        return ordersMap.get(orderId);
    }
}
