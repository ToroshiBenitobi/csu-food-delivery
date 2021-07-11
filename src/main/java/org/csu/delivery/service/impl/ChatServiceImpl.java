package org.csu.delivery.service.impl;

import org.csu.delivery.entity.Chat;
import org.csu.delivery.entity.Message;
import org.csu.delivery.entity.Shop;
import org.csu.delivery.entity.User;
import org.csu.delivery.repository.ChatRepository;
import org.csu.delivery.repository.MessageRepository;
import org.csu.delivery.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    ChatRepository chatRepository;
    @Autowired
    MessageRepository messageRepository;

    @Override
    public Chat createChat(User user, Shop shop) {
        Chat chat = new Chat();
        chat.setUser(user);
        chat.setShop(shop);
        chatRepository.save(chat);
        return chat;
    }

    @Override
    public void deleteChat(Chat chat) {
        chatRepository.delete(chat);
    }

    @Override
    public Message sendMessage(Chat chat, Message message) {
        message.setChat(chat);
        messageRepository.save(message);
        return message;
    }

    @Override
    public List<Message> getMessageList(Chat chat) {
        List<Message> messages = messageRepository.findAllByChat(chat);
        return messages;
    }

    @Override
    public List<Chat> getChatList(User user) {
        List<Chat> chatList = chatRepository.findAllByUser(user);
        return chatList;
    }

    @Override
    public List<Chat> getChatList(Shop shop) {
        List<Chat> chatList = chatRepository.findAllByShop(shop);
        return chatList;
    }
}
