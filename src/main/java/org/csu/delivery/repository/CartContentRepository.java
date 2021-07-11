package org.csu.delivery.repository;

import org.csu.delivery.entity.Cart;
import org.csu.delivery.entity.CartContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartContentRepository extends JpaRepository<CartContent, CartContent.PrimaryKey> {
    @Query("SELECT c FROM CartContent c WHERE c.pk.cartId = ?1")
    List<CartContent> getAllByCartId(Integer cartId);
    @Query("SELECT c FROM CartContent c WHERE c.pk.cartId = ?1 AND c.pk.productId = ?2")
    CartContent getByCartIdAndProductId(Integer cartId, Integer productId);
}
