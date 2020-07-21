package com.exercise.auction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.auction.exception.DBException;
import com.exercise.auction.exception.DBException.NoDataException;
import com.exercise.auction.exception.RecordNotFoundException;
import com.exercise.auction.model.Auction;
import com.exercise.auction.service.AuctionService;

@ControllerAdvice
@RestController
public class AuctionController {

	@Autowired
	AuctionService auctionService;

	@ExceptionHandler(RecordNotFoundException.class)
	@GetMapping(path = "/auctionItems")
	public ResponseEntity<List<Auction>> getAllAuctions() {
		List<Auction> list = auctionService.getAllAuctionItems();
		return new ResponseEntity<List<Auction>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(path = "/auctionItems/{auctionItemId}")
	public ResponseEntity<Auction> getAuctionById(@PathVariable("auctionItemId") Long id)
			throws NoDataException {
		Auction entity = auctionService.getAuctionById(id);
		return new ResponseEntity<Auction>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@ExceptionHandler(DBException.BadExecution.class)
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Auction> createOrUpdateAuction(@RequestBody Auction auction) {

		Auction updated = auctionService.createOrUpdateAuction(auction);
		return new ResponseEntity<Auction>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@ExceptionHandler(DBException.InvalidParam.class)
	@PostMapping(path = "/auctionItems", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {

		Auction updated = auctionService.createAuction(auction);
		return new ResponseEntity<Auction>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@ExceptionHandler(DBException.BiddingException.class)
	@PostMapping(path = "/bids", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Auction> postBids(@RequestBody Auction auction) {
		
		Auction updated = auctionService.postBid(auction);
		return new ResponseEntity<Auction>(updated, new HttpHeaders(),HttpStatus.OK);
	}
}
