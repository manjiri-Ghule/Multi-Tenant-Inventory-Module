package com.Inventory.dealer_inventory_system.DTO;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.*;


@Getter @Setter
public class VehicleRequestDTO {

    @SuppressWarnings("unused")
	private String model;
    @SuppressWarnings("unused")
	private BigDecimal price;
	@SuppressWarnings("unused")
	private String status;
	private UUID dealerId;
	public UUID getDealerId() {
		// TODO Auto-generated method stub
		return dealerId;
	}
	public String getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	public void setModel(String model) {
	    this.model = model;
	}
	public Object getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStatus1() {
		// TODO Auto-generated method stub
		return status;
	}
	
}