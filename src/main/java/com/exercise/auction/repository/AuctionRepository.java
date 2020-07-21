package com.exercise.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.auction.model.Auction;
import com.exercise.auction.model.Item;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

	void save(Item item);

}
