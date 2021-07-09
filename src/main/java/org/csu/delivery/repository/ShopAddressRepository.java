package org.csu.delivery.repository;

import org.csu.delivery.entity.ShopAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopAddressRepository extends JpaRepository<ShopAddress, Integer> {
}
