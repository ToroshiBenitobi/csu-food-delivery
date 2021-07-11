package org.csu.delivery;

import org.csu.delivery.entity.*;
import org.csu.delivery.entity.Order;
import org.csu.delivery.repository.AddressRepository;
import org.csu.delivery.repository.OrderRepository;
import org.csu.delivery.repository.ShopRepository;
import org.csu.delivery.repository.UserRepository;
import org.csu.delivery.service.*;
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
import java.util.List;
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
    @Autowired
    ShopService shopService;
    @Autowired
    CartService cartService;
    @Autowired
    CommentService commentService;
    @Autowired
    ChatService chatService;
    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
//        User user2 = new User("Anna", "Anna", 0, "Anna@x.al", "123", new Date(System.currentTimeMillis()));
////        Shop shop1 = new Shop();
////        Order order1 = new Order(100, "suspended", user1, shop1);
//        userRepository.save(user2);
//        shopRepository.save(shop1);
//        orderRepository.save(order1);
//        User user1 = userRepository.getById(1);
//        Shop shop1 = shopRepository.getById(1);
//        Order order1 = new Order(100, "suspended", user1, shop1);
//        Address address = new Address();
//        User user = userService.getUserById(1);
//        address.setLocation("123");
//        address.setMapX(1.8);
//        address.setMapY(2.7);
//        userService.addAddress(user, address);
//        userService.addAddress(user, address);
//        System.out.println(userService.getAddressList(user).size());
//        addressRepository.save(address);

//        Shop shop = new Shop();
//        shop.setShopName("Lina");
//        shop.setShopPic("1");
//        shop.setShoppDesc("123");
//        shop.setTelephone("123456");
//        ShopAddress shopAddress = new ShopAddress();
//        shopAddress.setLocation("Q");
//        shopAddress.setMapX(4.1);
//        shopAddress.setMapY(3.2);
//        shop.setAddress(shopAddress);
//
//        shopService.insertShop(shop);

//        cartService.createCart(userService.getUserById(1));
//        Cart cart = cartService.getCartList(userService.getUserById(1)).get(0);
//        Product product1 = shopService.getProductById(1);
//        Product product2 = shopService.getProductById(2);
//        cartService.addProduct(cart, product1);
//        cartService.addProduct(cart, product2);
//        cartService.updateQuantity(cart, product1, 3);
//        List<CartContent> contents = cartService.getCartContentList(cart);
//        contents.forEach(content -> System.out.println(content.toString()));

        User user1 = userService.getUserById(1);
        User user2 = userService.getUserById(5);
        Shop shop = shopService.getShopById(1);
        Product product1 = shopService.getProductById(1);
        Product product2 = shopService.getProductById(2);
        Comment comment1 = new Comment(user1, product1, 5, "美味しい");
        Comment comment2 = new Comment(user1, product2, 4, "ok");
        Comment comment3 = new Comment(user2, product1, 1, "no");
        commentService.createComment(comment1);
        commentService.createComment(comment2);
        commentService.createComment(comment3);
        List<Comment> commentList = commentService.getCommentList(shop);
        commentList.forEach(comment -> System.out.println(comment.getContent()));
    }
}
