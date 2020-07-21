package com.exercise.auction.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.auction.exception.DBException;
import com.exercise.auction.exception.RecordNotFoundException;
import com.exercise.auction.model.Auction;
import com.exercise.auction.repository.AuctionRepository;

@Service
public class AuctionService {

	@Autowired
	AuctionRepository auctionRepository;

	public List<Auction> getAllAuctionItems() {
		List<Auction> auctionList = auctionRepository.findAll();

		if (auctionList.size() > 0) {
			return auctionList;
		} else {
			return new ArrayList<Auction>();
		}
	}

	public Auction createOrUpdateAuction(Auction entity) throws RecordNotFoundException {
		Optional<Auction> auction = auctionRepository.findById(entity.getAuctionItemId());

		if (auction.isPresent()) {
			Auction newEntity = auction.get();
			newEntity.setAuctionItemId(entity.getAuctionItemId());
			newEntity.setCurrentBid(entity.getCurrentBid());
			newEntity.setItem(entity.getItem());
			newEntity.setBidderName(entity.getBidderName());
			newEntity.setReservePrice(entity.getReservePrice());

			newEntity = auctionRepository.save(newEntity);

			return newEntity;
		} else {
			entity = auctionRepository.save(entity);
			return entity;
		}
	}

	public Auction createAuction(Auction entity) throws RecordNotFoundException {
		entity.setCurrentBid(entity.getCurrentBid() == null ? BigDecimal.ZERO : entity.getCurrentBid());
		entity.setBidderName(entity.getBidderName() == null ? "" : entity.getBidderName());
		entity = auctionRepository.save(entity);
		return entity;
	}

	public Auction getAuctionById(Long id) throws DBException.NoDataException {

		 Optional<Auction> auction = auctionRepository.findById(id);
         
	        if(auction.isPresent()) {
	            return auction.get();
	        } else {
	            throw new DBException.NoDataException("No Auction record exist for given id");
	        }

	}

	public Auction postBid(Auction entity) throws RecordNotFoundException {

		Optional<Auction> auction = auctionRepository.findById(entity.getAuctionItemId());
		Auction newEntity = null;
		if (auction.isPresent()) {
			newEntity = auction.get();
			newEntity.setMaxAutoBidAmount(entity.getMaxAutoBidAmount());
			newEntity.setBidderName(entity.getBidderName());

			if (newEntity.getCurrentBid().compareTo(newEntity.getReservePrice()) < 0) {
				if (newEntity.getMaxAutoBidAmount().compareTo(newEntity.getReservePrice()) > 0) {
					newEntity.setCurrentBid(entity.getMaxAutoBidAmount());
				} else {
					newEntity.setCurrentBid(entity.getReservePrice());
				}
				newEntity = auctionRepository.save(newEntity);
			}

		}
		return newEntity; 
	}

}
