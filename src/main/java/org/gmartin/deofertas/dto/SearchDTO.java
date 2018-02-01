package org.gmartin.deofertas.dto;

import java.util.ArrayList;
import java.util.List;

import org.gmartin.deofertas.model.Store;

public class SearchDTO {
	private String desc;

    private List<StoreDTO> storesDTO;
    
    private List<Store> stores;

    private Double priceFrom;

    private Double priceTo;
    
    public SearchDTO() {};
    
    public SearchDTO(String desc,
			 String stores,
			 Double priceFrom,
			 Double priceTo) {
    	
    	List<StoreDTO> storesDTO = null;
    	
    	if (stores != null && stores.length() > 0) {
    		storesDTO = new ArrayList<>();
    		String[] storesArray = stores.split(",");
    		
    		for (String store : storesArray) {
				storesDTO.add(new StoreDTO(new Long(store), null));
			}
    	}
    	
    	this.desc = desc;
    	
    	if (storesDTO != null) {
    		this.storesDTO = storesDTO;
    	}
    	
    	if (priceFrom != null) {
    		this.priceFrom = priceFrom;
    	}
    	
    	if (priceTo != null) {
    		this.priceTo = priceTo;
    	}
    	
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

	public List<StoreDTO> getStoresDTO() {
		return storesDTO;
	}

	public void setStoresDTO(List<StoreDTO> storesDTO) {
		this.storesDTO = storesDTO;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
}
