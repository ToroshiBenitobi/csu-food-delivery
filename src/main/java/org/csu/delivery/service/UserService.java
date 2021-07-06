package org.csu.delivery.service;

import org.csu.delivery.entity.User;
import org.csu.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
//@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Cacheable(value = "user")
    public User getUserById(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }
}