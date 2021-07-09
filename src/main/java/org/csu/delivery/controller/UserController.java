package org.csu.delivery.controller;

import org.csu.delivery.entity.Address;
import org.csu.delivery.entity.User;
import org.csu.delivery.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        logger.info("Search user " + id);
        User user = userService.getUserById(id);
        return user;
    }
    @PostMapping("/user")
    public User insertUser(User user) {
        logger.info("Save user " + user.getUserId());
        User save = userService.insertUser(user);
        return save;
    }
    @PostMapping(value = "/user/{id}")
    public User updateUser(@PathVariable("id") Integer orderId, User user) {
        logger.info("Update user " + user.getUserId() + ".");
        User update = userService.updateUser(user);
        return update;
    }
    @DeleteMapping(value = "/user/{id}")
    public User deleteUser(@PathVariable("id") Integer id) {
        logger.info("Delete user " + id);
        User delete = userService.deleteUserById(id);
        return delete;
    }
    @GetMapping("user/address/{id}")
    public List<Address> getAddressList(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        List<Address> addressList = userService.getAddressList(user);
        logger.info("Search Address of user " + id);
        return addressList;
    }
}