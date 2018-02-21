package org.gmartin.deofertas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SUGGESTED_OFFERS")
public class SuggestedOffer extends GenericObject {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFER_ID", nullable = false)
	private Offer offer;
	
	@Column(name="IMAGE", nullable=true)
	private byte[] suggestedImage;
	
	@Column(name="SUGGESTION_DATE", nullable=false)
	private Date suggestionDate; 

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public byte[] getSuggestedImage() {
		return suggestedImage;
	}

	public void setSuggestedImage(byte[] suggestedImage) {
		this.suggestedImage = suggestedImage;
	}

	public Date getSuggestionDate() {
		return suggestionDate;
	}

	public void setSuggestionDate(Date suggestionDate) {
		this.suggestionDate = suggestionDate;
	}
}
