package com.exercise.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.exercise.auction"})
public class RestAuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAuctionApplication.class, args);

	}

}
