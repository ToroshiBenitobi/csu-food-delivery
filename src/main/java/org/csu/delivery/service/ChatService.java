package org.csu.delivery.service;

import org.csu.delivery.entity.Chat;
import org.csu.delivery.entity.Message;
import org.csu.delivery.entity.Shop;
import org.csu.delivery.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService {
    Chat createChat(User user, Shop shop);

    void deleteChat(Chat chat);

    Message sendMessage(Chat chat, Message message);

    List<Message> getMessageList(Chat chat);

    List<Chat> getChatList(User user);

    List<Chat> getChatList(Shop shop);

}
