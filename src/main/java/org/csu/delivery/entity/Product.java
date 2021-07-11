package org.csu.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;
    @Column
    private BigDecimal price;
    @Column
    private String productName;
    @Column
    private String productDesc;
    @Column
    private String productPic;

    public Product(Shop shop, String productName, String productDesc, BigDecimal price, String productPic) {
        this.shop = shop;
        this.price = price;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPic = productPic;
    }
}
