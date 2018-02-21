package org.gmartin.deofertas.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;

import org.gmartin.deofertas.dao.IGenericDAO;
import org.gmartin.deofertas.dao.IOfferImageDAO;
import org.gmartin.deofertas.dao.ISuggestedOfferDAO;
import org.gmartin.deofertas.dao.OfferImageDAO;
import org.gmartin.deofertas.dao.SuggestedOfferDAO;
import org.gmartin.deofertas.dto.OfferDTO;
import org.gmartin.deofertas.dto.OfferImageDTO;
import org.gmartin.deofertas.dto.SuggestedOfferDTO;
import org.gmartin.deofertas.model.Offer;
import org.gmartin.deofertas.model.OfferImage;
import org.gmartin.deofertas.model.SuggestedOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SuggestedOfferService {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	IGenericDAO<SuggestedOffer, Long> suggestedOfferDAO;
	
	@Autowired
	IGenericDAO<Offer, Long> offerDAO;
	
	ISuggestedOfferDAO customSuggestedOffer;
	
	@PostConstruct
	public void init(){
		customSuggestedOffer = (SuggestedOfferDAO)suggestedOfferDAO;
	}
	
	public SuggestedOfferDTO getLastSuggestedOffer(Long suggestionId) throws Exception{
		SuggestedOffer suggestedOffer = null;
		SuggestedOfferDTO suggestedOfferDTO = null;
		
		suggestedOffer = customSuggestedOffer.getLastSuggestedOffer(suggestionId);
		
		suggestedOfferDTO = modelToDTO(suggestedOffer);
		suggestedOfferDTO.setSuggestedImageStr(null);
		
		return suggestedOfferDTO;
	}
	
	public List<SuggestedOfferDTO> getSuggestedOffers() throws Exception{
		List<SuggestedOfferDTO> suggestedOffersDTO = new ArrayList<SuggestedOfferDTO>();
		List<SuggestedOffer> suggestedOffers = null;
		
		suggestedOffers = customSuggestedOffer.getSuggestedOfferLimited();
		
		for (SuggestedOffer suggested: suggestedOffers) {
			suggestedOffersDTO.add(modelToDTO(suggested));
		}
		
		return suggestedOffersDTO;		
	}
	
	private SuggestedOfferDTO modelToDTO (SuggestedOffer suggestedOffer) {
		SuggestedOfferDTO suggestedOfferDTO = new SuggestedOfferDTO();
		suggestedOfferDTO.setId(suggestedOffer.getId());
		
		if (suggestedOffer.getSuggestionDate() != null) {
			suggestedOfferDTO.setSuggestedDateStr(suggestedOffer.getSuggestionDate().toString());
		}
		
		if (suggestedOffer.getSuggestedImage() != null && suggestedOffer.getSuggestedImage().length > 0) {
			suggestedOfferDTO.setSuggestedImageStr(Base64.getEncoder().encodeToString(suggestedOffer.getSuggestedImage()));
		}
		
		if (suggestedOffer.getOffer() != null) {
			suggestedOfferDTO.setOfferId(suggestedOffer.getOffer().getId());
		}
		
		suggestedOfferDTO.setOffer(offerToOfferDTO(suggestedOffer.getOffer()));
		
		return suggestedOfferDTO;
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
		
		return offerDTO;
	}
}
