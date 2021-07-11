package org.csu.delivery.service.impl;

import org.csu.delivery.entity.*;
import org.csu.delivery.repository.OrderContentRepository;
import org.csu.delivery.repository.OrderRepository;
import org.csu.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderContentRepository contentRepository;

    @Override
    public Order insertOrder(Order order) {
        Order save = orderRepository.save(order);
        return order;
    }

    @Override
    public void deleteOrder(Order order) {
        List<OrderContent> orderContents = contentRepository.getAllByOrderId(order.getOrderId());
        contentRepository.deleteAll(orderContents);
        orderRepository.delete(order);
    }

    @Override
    public void updateStatus(Order order, String status) {
        order.setState(status);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderList(User user) {
        List<Order> orders = orderRepository.getAllByUser(user);
        return orders;
    }

    @Override
    public List<Order> getOrderList(Shop shop) {
        List<Order> orders = orderRepository.getAllByShop(shop);
        return orders;
    }

    @Override
    public OrderContent insertOrderContent(Order order, Product product, Integer quantity) {
        OrderContent content = new OrderContent();
        OrderContent.PrimaryKey primaryKey = new OrderContent.PrimaryKey();
        primaryKey.setOrderId(order.getOrderId());
        primaryKey.setProductId(product.getProductId());
        content.setPk(primaryKey);
        content.setQuantity(quantity);
        contentRepository.save(content);
        return content;
    }

    @Override
    public List<OrderContent> getOrderContentList(Order order) {
        List<OrderContent> orderContents = contentRepository.getAllByOrderId(order.getOrderId());
        return orderContents;
    }
}
