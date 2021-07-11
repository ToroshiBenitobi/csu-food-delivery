package org.csu.delivery.service;

import org.csu.delivery.entity.Cart;
import org.csu.delivery.entity.CartContent;
import org.csu.delivery.entity.Product;
import org.csu.delivery.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CartService {
    Cart createCart(User user);

    Cart addProduct(Cart cart, Product product);

    Cart removeProduct(Cart cart, Product product);

    Cart updateQuantity(Cart cart, Product product, Integer quantity);

    void deleteCart(Cart cart);

    List<Cart> getCartList(User user);

    List<CartContent> getCartContentList(Cart cart);
}
