package org.gmartin.deofertas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfferImageDTO {

	private Long id;
	private Long offerId;
	private String path;
	private String hashId;
	private String image;

	public OfferImageDTO(){};
	
	public OfferImageDTO(Long id,
						 Long offerId,
						 String hashId,
						 String path) {
		
		this.id = id;
		this.offerId = offerId;
		this.path = path;
		this.hashId = hashId;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty(value="offer_id")
	public Long getOfferId() {
		return offerId;
	}

	@JsonProperty(value="offer_id")
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@JsonProperty(value="hash_id")
	public String getHashId() {
		return hashId;
	}

	@JsonProperty(value="hash_id")
	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
