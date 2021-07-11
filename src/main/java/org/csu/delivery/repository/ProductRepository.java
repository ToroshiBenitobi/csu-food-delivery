package org.csu.delivery.repository;

import org.csu.delivery.entity.Product;
import org.csu.delivery.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByShop(Shop shop);
}
