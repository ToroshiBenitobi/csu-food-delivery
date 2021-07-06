package org.csu.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CsuFoodDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsuFoodDeliveryApplication.class, args);
    }

}
