package com.learning.lld.amazonlocker2.service;

import com.learning.lld.amazonlocker2.model.Item;
import com.learning.lld.amazonlocker2.model.Order;
import com.learning.lld.amazonlocker2.repository.OrderRepository;

import java.util.List;

public class OrderService {

    OrderRepository orderRepository = new OrderRepository();

    public Order getOrder(String orderId) {
        return orderRepository.getOrder(orderId);
    }

    public List<Item> getItemsForOrder(String orderId) {
        return orderRepository.getOrder(orderId).getItems();
    }

    public void initiateRefund(String orderId) {
        System.out.printf("Refund for order %s initiated", orderId);
    }

}