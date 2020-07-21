package com.exercise.auction.restAuction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exercise.auction.controller.AuctionController;

@SpringBootTest
class RestAuctionApplicationTests {
	@Autowired
	private AuctionController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
