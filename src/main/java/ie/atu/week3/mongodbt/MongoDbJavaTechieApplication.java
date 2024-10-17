package ie.atu.week3.mongodbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MongoDbJavaTechieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbJavaTechieApplication.class, args);
    }

}
