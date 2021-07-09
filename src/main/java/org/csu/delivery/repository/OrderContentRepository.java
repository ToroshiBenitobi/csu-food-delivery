package org.csu.delivery.repository;

import org.csu.delivery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderContentRepository extends JpaRepository<Order, Integer> {
}
