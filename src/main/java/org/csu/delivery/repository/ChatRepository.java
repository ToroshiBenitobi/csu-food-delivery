package org.csu.delivery.repository;

import org.csu.delivery.entity.Chat;
import org.csu.delivery.entity.Shop;
import org.csu.delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    List<Chat> findAllByShop(Shop shop);
    List<Chat> getAllByShop(Shop shop);
    List<Chat> findAllByUser(User user);
}
