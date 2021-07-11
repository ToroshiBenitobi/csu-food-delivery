package org.csu.delivery.service.impl;

import org.csu.delivery.entity.Address;
import org.csu.delivery.entity.User;
import org.csu.delivery.repository.AddressRepository;
import org.csu.delivery.repository.UserRepository;
import org.csu.delivery.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
//    @Autowired
//    Logger logger = LoggerFactory.getLogger(getClass());

    @Cacheable(key = "'user' + #id")
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public User updateUser(User user) {
        User update = userRepository.getById(user.getUserId());
        userRepository.save(user);
        return update;
    }

    @Override
    public User deleteUser(User user) {
        userRepository.delete(user);
        return user;
    }

    @Override
    public User deleteUserById(Integer id) {
        User delete = userRepository.getById(id);
        userRepository.deleteById(id);
        return delete;
    }

    @Override
    public Address addAddress(User user, Address address) {
        address.setUser(user);
        Address save = addressRepository.save(address);
        return save;
    }

    @Override
    public Address removeAddress(Address address) {
        Address delete = addressRepository.findById(address.getAddressId()).get();
        addressRepository.deleteById(address.getAddressId());
        return delete;
    }

    @Override
    @Cacheable(key = "'addressByUser' + #user.userId")
    public List<Address> getAddressList(User user) {
        List<Address> addressList = addressRepository.findByUser(user);
        return addressList;
    }

    @Override
    public Address updateAddress(Address address) {
        Address update = addressRepository.getById(address.getAddressId());
        addressRepository.save(address);
        return update;
    }

    @Override
    @Cacheable()
    public User getUserByUserName(String userName) {
        User user = userRepository.getUserByUserName(userName);
        return user;
    }
}