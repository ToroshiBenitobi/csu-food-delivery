package org.csu.delivery.service;

import org.csu.delivery.entity.*;

import java.util.List;

public interface OrderService {
    Order insertOrder(Order order);

    OrderContent insertOrderContent(Order order, Product product, Integer quantity);

    void deleteOrder(Order order);

    void updateStatus(Order order, String status);

    List<Order> getOrderList(User user);

    List<Order> getOrderList(Shop shop);

    List<OrderContent> getOrderContentList(Order order);
}
