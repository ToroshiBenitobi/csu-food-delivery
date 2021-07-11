package org.csu.delivery.service;

import org.csu.delivery.entity.Address;
import org.csu.delivery.entity.Product;
import org.csu.delivery.entity.Shop;
import org.csu.delivery.entity.ShopAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    Shop insertShop(Shop shop);

    void removeShop(Shop shop);

    Shop updateShop(Shop shop);

    Shop getShopById(Integer id);

    List<Shop> getShopList();

    List<Product> getProductList(Shop shop);

    Shop insertProduct(Shop shop, Product product);

    void removeProduct(Product product);

    Product updateProduct(Product product);

    Product getProductById(Integer id);
}
