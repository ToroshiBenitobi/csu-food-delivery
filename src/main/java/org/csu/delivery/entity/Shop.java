package org.csu.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String shopPid;
    @Column
    private String shoppDesc;
    @Column
    private String telephone;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}
