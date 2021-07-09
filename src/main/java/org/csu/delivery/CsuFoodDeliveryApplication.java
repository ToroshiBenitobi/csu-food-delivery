package org.csu.delivery;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@EnableRabbit
@SpringBootApplication
public class CsuFoodDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsuFoodDeliveryApplication.class, args);
    }

}
