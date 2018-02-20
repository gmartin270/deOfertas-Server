package org.gmartin.deofertas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OFFERS")
public class Offer extends GenericObject {

	@Column(name="HASH_ID", nullable=false)
	private String hashId;
	
	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="DESCRIPTION", nullable=true)
    private String description;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="STORE_ID", nullable=false)
    private Store store;
	
	@Column(name="PRICE", nullable=false)
    private Double price;
	
	@Column(name="FAVORITE", nullable=false)
    private boolean favorite;
	
	@Column(name="LINK", nullable=true)
	private String link;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer", targetEntity=OfferImage.class)
	private List<OfferImage> images;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offer", targetEntity=SuggestedOffer.class)
	private List<SuggestedOffer> suggestedOffers;
    
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<OfferImage> getImages() {
		return images;
	}

	public void setImages(List<OfferImage> images) {
		this.images = images;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<SuggestedOffer> getSuggestedOffers() {
		return suggestedOffers;
	}

	public void setSuggestedOffers(List<SuggestedOffer> suggestedOffers) {
		this.suggestedOffers = suggestedOffers;
	}
}

