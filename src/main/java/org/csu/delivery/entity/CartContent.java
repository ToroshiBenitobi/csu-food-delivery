package org.csu.delivery.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
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
        Integer cartId;

        @Column(name = "product_id")
        Integer productId;

        public Integer getCartId() {
            return cartId;
        }

        public void setCartId(Integer cartId) {
            this.cartId = cartId;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        //        @ManyToOne
//        private Cart cart;
//
//        @ManyToOne
//        private Product product;
    }
}
