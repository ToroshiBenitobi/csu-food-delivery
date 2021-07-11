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
@Table(name = "order_contents")
public class OrderContent implements Serializable {
    @EmbeddedId
    private PrimaryKey pk;

    @Column
    private Integer quantity;

    @Getter
    @Setter
    @NoArgsConstructor
    @Embeddable
    public static class PrimaryKey implements Serializable {

        @Column(name = "order_id")
        private Integer orderId;

        @Column(name = "product_id")
        private Integer productId;
    }


}
