package org.csu.delivery.service;

import org.csu.delivery.entity.Address;
import org.csu.delivery.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig(cacheNames = "user")
public interface UserService {

    User getUserById(Integer id);

    User getUserByUserName(String userName);

    User insertUser(User user);

    User updateUser(User user);

    User deleteUser(User user);

    User deleteUserById(Integer id);

    Address addAddress(User user, Address address);

    Address removeAddress(Address address);

    List<Address> getAddressList(User user);

    Address updateAddress(Address address);
}