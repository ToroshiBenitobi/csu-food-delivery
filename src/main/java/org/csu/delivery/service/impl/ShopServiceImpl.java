package org.csu.delivery.service.impl;

import org.csu.delivery.entity.Product;
import org.csu.delivery.entity.Shop;
import org.csu.delivery.entity.ShopAddress;
import org.csu.delivery.repository.ProductRepository;
import org.csu.delivery.repository.ShopAddressRepository;
import org.csu.delivery.repository.ShopRepository;
import org.csu.delivery.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShopAddressRepository shopAddressRepository;

    @Override
    public Shop insertShop(Shop shop) {
        shopAddressRepository.save(shop.getAddress());
        Shop save = shopRepository.save(shop);
        return save;
    }

    @Override
    public void removeShop(Shop shop) {
        shopRepository.delete(shop);
        shopAddressRepository.delete(shop.getAddress());
    }

    @Override
    public Shop updateShop(Shop shop) {
        shopAddressRepository.save(shop.getAddress());
        Shop update = shopRepository.save(shop);
        return update;
    }

    @Override
    public Shop getShopById(Integer id) {
        Shop shop = shopRepository.findById(id).orElse(null);
        return shop;
    }

    @Override
    public List<Shop> getShopList() {
        List<Shop> shopList = shopRepository.findAll();
        return shopList;
    }

    @Override
    public List<Product> getProductList(Shop shop) {
        List<Product> productList = productRepository.findAllByShop(shop);
        return productList;
    }

    @Override
    public Shop insertProduct(Shop shop, Product product) {
        product.setShop(shop);
        productRepository.save(product);
        return null;
    }

    @Override
    public void removeProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product update = productRepository.save(product);
        return null;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }
}
