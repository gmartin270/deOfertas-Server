package org.gmartin.deofertas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreDTO {

	private Long id;
	private String businessName;
	private byte[] logo;
	
	public StoreDTO() {};
	
	public StoreDTO(Long id,
					String businessName){
		
		this.id = id;
		this.businessName = businessName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty(value="business_name")
	public String getBusinessName() {
		return businessName;
	}

	@JsonProperty(value="business_name")
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
}
