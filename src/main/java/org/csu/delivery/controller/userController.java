package org.csu.delivery.controller;

import org.csu.delivery.entity.User;
import org.csu.delivery.repository.UserRepository;
import org.csu.delivery.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class userController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        logger.info("search user " + id);
        User user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        logger.info("save user " + user.getId());
        User save = userService.insertUser(user);
        return save;
    }
}
