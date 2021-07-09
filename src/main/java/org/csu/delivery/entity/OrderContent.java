package org.csu.delivery.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "order_contents")
public class OrderContent implements Serializable {
    @EmbeddedId
    private PrimaryKey pk;

    @Column
    private Integer quantity;

    @Getter
    @NoArgsConstructor
    @Embeddable
    public static class PrimaryKey implements Serializable {

        @Column(name = "order_id")
        private Integer order_id;

        @Column(name = "product_id")
        private Integer productId;
    }
}
