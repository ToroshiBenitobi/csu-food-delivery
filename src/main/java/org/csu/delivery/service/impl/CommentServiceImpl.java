package org.csu.delivery.service.impl;

import org.csu.delivery.entity.Comment;
import org.csu.delivery.entity.Product;
import org.csu.delivery.entity.Shop;
import org.csu.delivery.entity.User;
import org.csu.delivery.repository.CommentRepository;
import org.csu.delivery.repository.ProductRepository;
import org.csu.delivery.repository.ShopRepository;
import org.csu.delivery.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Comment createComment(Comment comment) {
        Comment save = commentRepository.save(comment);
        return save;
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        Comment update = commentRepository.save(comment);
        return update;
    }

    @Override
    public List<Comment> getCommentList(User user) {
        List<Comment> comments = commentRepository.findAllByUser(user);
        return comments;
    }

    @Override
    public List<Comment> getCommentList(Product product) {
        List<Comment> comments = commentRepository.findAllByProduct(product);
        return comments;
    }

    @Override
    public List<Comment> getCommentList(Shop shop) {
        List<Product> productList = productRepository.findAllByShop(shop);
        List<Comment> comments = new ArrayList<>();
        productList.forEach(product -> {
            comments.addAll(commentRepository.findAllByProduct(product));
        });
        return comments;
    }
}
