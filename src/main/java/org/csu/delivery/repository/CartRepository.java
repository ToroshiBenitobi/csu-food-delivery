package org.csu.delivery.repository;

import org.csu.delivery.entity.Cart;
import org.csu.delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> getAllByUser(User user);
}
