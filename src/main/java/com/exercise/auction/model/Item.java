package com.exercise.auction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@Column(name="item_id")
	private String itemId;
	
	@Column(name="item_description")
	private String description;
	
  //  @OneToMany(mappedBy = "item")//, cascade = CascadeType.ALL, orphanRemoval = true
//    @JsonIgnore
//    private List<Auction> auctions;

	public Item() {
	}
	public Item(String id, String desc) {
		this.itemId = id;
		this.description = desc;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public List<Auction> getAuction() {
//		return auctions;
//	}
//	public void setAuction(List<Auction> auction) {
//		this.auctions = auction;
//	}
}
