package org.csu.delivery.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "cart_contents")
public class CartContent implements Serializable {
    @EmbeddedId
    private PrimaryKey pk;

//    @ManyToOne
//    @MapsId("cart_id")
//    private Cart cart;
//
//    @ManyToOne
//    @MapsId("product_id")
//    private Product product;

    @Column
    private Integer quantity;

    @Getter
    @NoArgsConstructor
    @Embeddable
    public static class PrimaryKey implements Serializable {

        @Column(name = "cart_id")
        private Integer cartId;

        @Column(name = "product_id")
        private Integer productId;
//        @ManyToOne
//        private Cart cart;
//
//        @ManyToOne
//        private Product product;
    }
}
