package com.exercise.auction.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercise.auction.model.Auction;
import com.exercise.auction.repository.AuctionRepository;

@RunWith(SpringRunner.class)

public class AuctionServiceTest {

    @Autowired
	public AuctionService client;
    
	@MockBean
	private AuctionRepository repository;
	
	@Test
	public void testGetAllAuctionTest() {

		List<Auction> userServiceResponse = client.getAllAuctionItems();

	}


}
