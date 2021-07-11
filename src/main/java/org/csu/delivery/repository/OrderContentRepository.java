package org.csu.delivery.repository;


import org.csu.delivery.entity.CartContent;
import org.csu.delivery.entity.OrderContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderContentRepository extends JpaRepository<OrderContent, Integer> {
    @Query("SELECT c FROM OrderContent c WHERE c.pk.orderId = ?1")
    List<OrderContent> getAllByOrderId(Integer orderId);
}
