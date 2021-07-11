package org.csu.delivery.repository;

import org.csu.delivery.entity.Comment;
import org.csu.delivery.entity.Product;
import org.csu.delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByUser(User user);
    List<Comment> findAllByProduct(Product product);
}
