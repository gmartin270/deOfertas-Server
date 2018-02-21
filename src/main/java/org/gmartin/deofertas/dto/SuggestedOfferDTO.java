package org.gmartin.deofertas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuggestedOfferDTO {
	private Long id;
	private Long offerId;
	private String suggestedImageStr;
	private String suggestedDateStr;
	private String path;
	private OfferDTO offer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	@JsonProperty(value="suggested_image_str")
	public String getSuggestedImageStr() {
		return suggestedImageStr;
	}

	@JsonProperty(value="suggested_image_str")
	public void setSuggestedImageStr(String suggestedImageStr) {
		this.suggestedImageStr = suggestedImageStr;
	}

	@JsonProperty(value="suggested_date_str")
	public String getSuggestedDateStr() {
		return suggestedDateStr;
	}

	@JsonProperty(value="suggested_date_str")
	public void setSuggestedDateStr(String suggestedDateStr) {
		this.suggestedDateStr = suggestedDateStr;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public OfferDTO getOffer() {
		return offer;
	}

	public void setOffer(OfferDTO offer) {
		this.offer = offer;
	}
}
