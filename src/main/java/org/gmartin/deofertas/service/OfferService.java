package org.gmartin.deofertas.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.gmartin.deofertas.dao.IGenericDAO;
import org.gmartin.deofertas.dao.IOfferDAO;
import org.gmartin.deofertas.dao.OfferDAO;
import org.gmartin.deofertas.dto.OfferDTO;
import org.gmartin.deofertas.dto.SearchDTO;
import org.gmartin.deofertas.dto.StoreDTO;
import org.gmartin.deofertas.model.Offer;
import org.gmartin.deofertas.model.OfferImage;
import org.gmartin.deofertas.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OfferService {
	@Autowired
	IGenericDAO<Offer, Long> offerDAO;
	
	@Autowired
	IGenericDAO<Store, Long> storeDAO;
	
	@Autowired
	IGenericDAO<OfferImage, Long> offerImageDAO;
	
	IOfferDAO customOffer;
	
	@PostConstruct
	public void init(){
		customOffer = (OfferDAO)offerDAO;
	}
	
	public OfferDTO getOffer(Long id) throws Exception{
		
		return offerToOfferDTO(offerDAO.load(id));		
	}
	
	public List<OfferDTO> getOffer(SearchDTO searchDTO) throws Exception{
		List<OfferDTO> offersDTO = new ArrayList<OfferDTO>();
		List<Offer> offers = null;
		List<Store> stores = new ArrayList<Store>();
		Store store = null;
		
		if (searchDTO.getStoresDTO() != null) {
			for (StoreDTO storeDTO : searchDTO.getStoresDTO()) {
				store = storeDAO.load(storeDTO.getId());
				stores.add(store);
			}
			
			searchDTO.setStores(stores);
		}
		
		offers = customOffer.getOfferByCriteria(searchDTO);		
		
		for (Offer offer : offers) {
			offersDTO.add(offerToOfferDTO(offer));
		}
		
		return offersDTO;		
	}
	
	private OfferDTO offerToOfferDTO (Offer offer) {
		OfferDTO offerDTO = new OfferDTO();
		
		offerDTO.setTitle(offer.getTitle());
		offerDTO.setDesc(offer.getDescription());
		offerDTO.setHashId(offer.getHashId());
		offerDTO.setId(offer.getId());
		offerDTO.setPrice(offer.getPrice());
		offerDTO.setStoreId(offer.getStore().getId());
		offerDTO.setStoreName(offer.getStore().getBusinessName());
		offerDTO.setLink(offer.getLink());
		
		OfferImage image;
		
		if (offer.getImages() != null && offer.getImages().size() > 0) {
			image = offer.getImages().get(0);
			offerDTO.setImage(Base64.getEncoder().encodeToString(image.getImage()));
		}
		
		return offerDTO;
	}
	
	private Offer offerDTOToOffer (OfferDTO offerDTO) {
		Offer offer = new Offer();
		
		if (offerDTO.getStoreId() != null) {
			offer.setStore(storeDAO.load(offerDTO.getStoreId()));
		}
		
		offer.setTitle(offerDTO.getTitle());
		offer.setDescription(offerDTO.getDesc());
		offer.setHashId(offerDTO.getHashId());
		offer.setId(offerDTO.getId());
		offer.setPrice(offerDTO.getPrice());
		
		return offer;
	}
}
