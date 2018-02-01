package org.gmartin.deofertas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OFFER_IMAGES")
public class OfferImage extends GenericObject {
	
	@Column(name="HASH_ID", nullable=false)
	private String hashId;
	
	@Column(name="IMAGE", nullable=false)
	private byte[] image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFER_ID", nullable = false)
	private Offer offer;

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
