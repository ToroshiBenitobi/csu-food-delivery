package org.csu.delivery.repository;

import org.csu.delivery.entity.Address;
import org.csu.delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByUser(User user);
}
