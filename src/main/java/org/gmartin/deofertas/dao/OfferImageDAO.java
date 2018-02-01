package org.gmartin.deofertas.dao;

import java.util.ArrayList;
import java.util.List;

import org.gmartin.deofertas.model.OfferImage;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class OfferImageDAO extends GenericDAOImpl<OfferImage, Long> implements IOfferImageDAO{

	@Override
	public List<OfferImage> getOfferImageByCriteria(OfferImage offerImage) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (offerImage.getId() != null) {
			criterions.add(Restrictions.eq("id", offerImage.getId()));
		}

		if (offerImage.getHashId() != null) {
			criterions.add(Restrictions.eq("hash_id", offerImage.getHashId()));
		}
		
		if (offerImage.getOffer() != null) {
			criterions.add(Restrictions.eq("offer", offerImage.getOffer()));
		}

		return this.getByCriteria(criterions);
	}
}
