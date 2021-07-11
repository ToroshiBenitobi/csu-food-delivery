package org.csu.delivery.repository;

import org.csu.delivery.entity.Chat;
import org.csu.delivery.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByChat(Chat chat);
}
