package com.exercise.auction.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exercise.auction.exception.RecordNotFoundException;
import com.exercise.auction.model.Auction;
import com.exercise.auction.model.Item;
import com.exercise.auction.service.AuctionService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AuctionControllerTest{

	  @Autowired
	  private MockMvc mockMvc;
	  
	  @MockBean
	  private AuctionService service;

	  @ExceptionHandler({RecordNotFoundException.class})
	  @Test
	  public void getAllAuctionTest() throws Exception{

		  Auction auction = new Auction();
		  auction.setAuctionItemId(1L);
		  auction.setItem(new Item("abcde","Test item description"));
		  auction.setReservePrice(BigDecimal.valueOf(45.50));
		  auction.setMaxAutoBidAmount(BigDecimal.valueOf(55.00));
		  
		  List<Auction> auctions = Arrays.asList(auction);
		  Mockito.when(service.getAllAuctionItems()).thenReturn(auctions);
		  given(service.getAllAuctionItems()).willReturn(auctions);
		  
	        this.mockMvc.perform(get("http://localhost:5000/auction/auctionItems"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("application/json"))
	                .andExpect(content().json("[{'auctionItemId:': 1,'reservePrice':45.50,'maxAutoBidAmount':55,item: {\r\n" + 
	                		"itemId: \"abcd\",\r\n" + 
	                		"description: \"item description 1\",\r\n" + 
	                		"}"
	                		+ "}]"));
	        


	  }
	  
}
