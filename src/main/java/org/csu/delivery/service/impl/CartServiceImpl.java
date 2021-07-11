package org.csu.delivery.service.impl;

import org.csu.delivery.entity.Cart;
import org.csu.delivery.entity.CartContent;
import org.csu.delivery.entity.Product;
import org.csu.delivery.entity.User;
import org.csu.delivery.repository.CartContentRepository;
import org.csu.delivery.repository.CartRepository;
import org.csu.delivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartContentRepository contentRepository;

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart addProduct(Cart cart, Product product) {
        CartContent content = new CartContent();
        CartContent.PrimaryKey primaryKey = new CartContent.PrimaryKey();
        primaryKey.setCartId(cart.getCartId());
        primaryKey.setProductId(product.getProductId());
        content.setPk(primaryKey);
        content.setQuantity(1);
        contentRepository.save(content);
        return cart;
    }

    @Override
    public Cart removeProduct(Cart cart, Product product) {
        CartContent content = contentRepository.getByCartIdAndProductId(
                cart.getCartId(),
                product.getProductId()
        );
        contentRepository.delete(content);
        return cart;
    }

    @Override
    public Cart updateQuantity(Cart cart, Product product, Integer quantity) {
//        CartContent.PrimaryKey pk = new CartContent.PrimaryKey();
//        pk.setCartId(cart.getCartId());
//        pk.setProductId(product.getProductId());
        CartContent content = contentRepository.getByCartIdAndProductId(
                cart.getCartId(),
                product.getProductId()
        );
        content.setQuantity(quantity);
        contentRepository.save(content);
        return cart;
    }

    @Override
    public void deleteCart(Cart cart) {
        List<CartContent> cartContents =
                contentRepository.getAllByCartId(cart.getCartId());
        contentRepository.deleteAll(cartContents);
        cartRepository.delete(cart);
    }

    @Override
    public List<Cart> getCartList(User user) {
        List<Cart> carts = cartRepository.getAllByUser(user);
        return carts;
    }

    @Override
    public List<CartContent> getCartContentList(Cart cart) {
        List<CartContent> cartContents =
                contentRepository.getAllByCartId(cart.getCartId());
        return cartContents;
    }
}
