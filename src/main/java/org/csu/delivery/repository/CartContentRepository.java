package org.csu.delivery.repository;

import org.csu.delivery.entity.CartContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartContentRepository extends JpaRepository<CartContent, CartContent.PrimaryKey> {
}
