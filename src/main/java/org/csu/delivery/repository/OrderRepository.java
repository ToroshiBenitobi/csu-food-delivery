package org.csu.delivery.repository;

import org.csu.delivery.entity.Order;
import org.csu.delivery.entity.Shop;
import org.csu.delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> getAllByUser(User user);

    List<Order> getAllByShop(Shop shop);
}
