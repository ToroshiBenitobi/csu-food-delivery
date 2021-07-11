package org.csu.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "shops")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopId;
    @Column
    private String shopName;
    @Column
    private String shopPic;
    @Column
    private String shoppDesc;
    @Column
    private String telephone;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ShopAddress address;

    public Shop(String shopName, String shoppDesc, ShopAddress address, String telephone, String shopPic) {
        this.shopName = shopName;
        this.shopPic = shopPic;
        this.shoppDesc = shoppDesc;
        this.telephone = telephone;
        this.address = address;
    }
}
