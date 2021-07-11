package org.csu.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "shop_address_list")
public class ShopAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    @Column
    private String location;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String county;
    @Column
    private Double mapX;
    @Column
    private Double mapY;

    public ShopAddress(String province, String city, String county, String location, Double mapX, Double mapY) {
        this.location = location;
        this.province = province;
        this.city = city;
        this.county = county;
        this.mapX = mapX;
        this.mapY = mapY;
    }
}
