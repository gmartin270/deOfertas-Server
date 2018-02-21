package org.gmartin.deofertas.dao;

import java.util.ArrayList;
import java.util.List;

import org.gmartin.deofertas.model.SuggestedOffer;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SuggestedOfferDAO extends GenericDAOImpl<SuggestedOffer, Long> implements ISuggestedOfferDAO{

	@Override
	public List<SuggestedOffer> getSuggestedOfferByCriteria(SuggestedOffer suggestedOffer) {
		List<Criterion> criterions = new ArrayList<Criterion>();

//		if (offerImage.getId() != null) {
//			criterions.add(Restrictions.eq("id", offerImage.getId()));
//		}
//
//		if (offerImage.getHashId() != null) {
//			criterions.add(Restrictions.eq("hash_id", offerImage.getHashId()));
//		}
//		
//		if (offerImage.getOffer() != null) {
//			criterions.add(Restrictions.eq("offer", offerImage.getOffer()));
//		}

		return this.getByCriteria(criterions);
	}
	
	@SuppressWarnings("unchecked")
	public List<SuggestedOffer> getSuggestedOfferLimited() {
		Query query = currentSession().createQuery("FROM SuggestedOffer ORDER BY suggestionDate DESC");
		query.setFirstResult(0);
		query.setMaxResults(5);
		return (List<SuggestedOffer>)query.list();
	}
	
	@SuppressWarnings("unchecked")
	public SuggestedOffer getLastSuggestedOffer(Long suggestionId) {
		Query query = currentSession().createQuery("FROM SuggestedOffer WHERE id = (SELECT MAX(id) FROM SuggestedOffer) AND id > :id"); //WHERE suggestionDate > current_date()
		query.setParameter("id", suggestionId);
		SuggestedOffer suggestedOffer = (SuggestedOffer)query.uniqueResult();
		
		if (suggestedOffer == null) {
			suggestedOffer = new SuggestedOffer();
		}
		return suggestedOffer;
	}
}
