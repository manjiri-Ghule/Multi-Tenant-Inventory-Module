package com.Inventory.dealer_inventory_system.DTO;

import java.util.UUID;

import lombok.*;

@Getter @Setter
public class DealerDTO {
	@SuppressWarnings("unused")
	private UUID id;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String email;
	@SuppressWarnings("unused")
	private String subscriptionType;
	public void setId(Object id) {
		// TODO Auto-generated method stub
		this.id = (UUID) id;
	}
	public void setName(Object name) {
		// TODO Auto-generated method stub
		this.name = (String) name;
	}
	public void setEmail(Object email) {
		// TODO Auto-generated method stub
		this.email = (String) email;
	}
	public void setSubscriptionType(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

}