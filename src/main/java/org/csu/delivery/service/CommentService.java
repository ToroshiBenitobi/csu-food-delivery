package org.csu.delivery.service;

import org.csu.delivery.entity.Comment;
import org.csu.delivery.entity.Product;
import org.csu.delivery.entity.Shop;
import org.csu.delivery.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment createComment(Comment comment);

    void deleteComment(Comment comment);

    Comment updateComment(Comment comment);

    List<Comment> getCommentList(User user);

    List<Comment> getCommentList(Product product);

    List<Comment> getCommentList(Shop shop);
}
