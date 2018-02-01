package org.gmartin.deofertas.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfferDTO {

	private Long id;
    private String hashId;
    private String desc;
    private Long storeId;
    private String storeName;
    private Double price;
    private Boolean favorite;
    private List<byte[]> images;
    
    public OfferDTO(){}
    
    public OfferDTO(Long id,
    				String hashId,
    				String desc,
    				Long storeId,
    				Double price,
    				Boolean favorite) {
    	
    	this.id = id;
    	this.hashId = hashId;
    	this.desc = desc;
    	this.storeId = storeId;
    	this.price = price;
    	this.favorite = favorite;    	
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

	public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    @JsonProperty(value="hash_id")
    public String getHashId() {
        return hashId;
    }

    @JsonProperty(value="hash_id")
    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    @JsonProperty(value="store_id")
	public Long getStoreId() {
		return storeId;
	}

    @JsonProperty(value="store_id")
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public List<byte[]> getImages() {
		return images;
	}

	public void setImages(List<byte[]> images) {
		this.images = images;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}

