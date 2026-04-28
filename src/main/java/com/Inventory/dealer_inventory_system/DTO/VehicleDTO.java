package com.Inventory.dealer_inventory_system.DTO;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.*;

@Getter @Setter
public class VehicleDTO {

    @SuppressWarnings("unused")
	private UUID id;
    @SuppressWarnings("unused")
	private String model;
    @SuppressWarnings("unused")
	private BigDecimal price;
    @SuppressWarnings("unused")
	private String status;
    @SuppressWarnings("unused")
	private Object dealerId;
	public void setId(UUID id2) {
		// TODO Auto-generated method stub
		
	}
	public void setModel(String model2) {
		// TODO Auto-generated method stub
		
	}
	public void setPrice(BigDecimal price2) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(String name) {
		// TODO Auto-generated method stub
		
	}
	public void setDealerId(Object object) {
		// TODO Auto-generated method stub
		this.dealerId = object;
	}
}