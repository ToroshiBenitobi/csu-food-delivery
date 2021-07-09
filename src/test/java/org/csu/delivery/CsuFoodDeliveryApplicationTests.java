package org.csu.delivery;

import org.csu.delivery.entity.*;
import org.csu.delivery.entity.Order;
import org.csu.delivery.repository.AddressRepository;
import org.csu.delivery.repository.OrderRepository;
import org.csu.delivery.repository.ShopRepository;
import org.csu.delivery.repository.UserRepository;
import org.csu.delivery.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CsuFoodDeliveryApplicationTests {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
//        User user2 = new User("Anna", "Anna", 0, "Anna@x.al", "123", new Date(System.currentTimeMillis()));
//        Shop shop1 = new Shop();
//        Order order1 = new Order(100, "suspended", user1, shop1);
//        userRepository.save(user2);
//        shopRepository.save(shop1);
//        orderRepository.save(order1);
//        User user1 = userRepository.getById(1);
//        Shop shop1 = shopRepository.getById(1);
//        Order order1 = new Order(100, "suspended", user1, shop1);
        Address address = addressRepository.getById(3);
        User user = userService.getUserById(1);
        address.setLocation("123");
        address.setMapX(1.8);
        address.setMapY(2.7);
        userService.updateAddress(address);
//        userService.addAddress(user, address);
        System.out.println(userService.getAddressList(user).size());
//        addressRepository.save(address);
    }
}
