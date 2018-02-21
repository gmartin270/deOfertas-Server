package org.gmartin.deofertas.dao;

import java.util.List;

import org.gmartin.deofertas.model.SuggestedOffer;

public interface ISuggestedOfferDAO extends IGenericDAO<SuggestedOffer, Long>{

	List<SuggestedOffer> getSuggestedOfferByCriteria(SuggestedOffer suggestedOffer);
	
	List<SuggestedOffer> getSuggestedOfferLimited();
	
	SuggestedOffer getLastSuggestedOffer(Long suggestionId);
}