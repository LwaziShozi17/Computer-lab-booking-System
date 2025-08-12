package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "za.ac.cput")
public class Main {
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Computer Lab Booking System is running!");
    }
}
