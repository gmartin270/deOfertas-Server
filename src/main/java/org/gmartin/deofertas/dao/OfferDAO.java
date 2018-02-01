package org.gmartin.deofertas.dao;

import java.util.ArrayList;
import java.util.List;

import org.gmartin.deofertas.dto.SearchDTO;
import org.gmartin.deofertas.model.Offer;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class OfferDAO extends GenericDAOImpl<Offer, Long> implements IOfferDAO {

	@Override
	public List<Offer> getOfferByCriteria(SearchDTO searchDTO) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (searchDTO.getStores() != null) {
			criterions.add(Restrictions.in("store", searchDTO.getStores()));
		}

		if (searchDTO.getPriceFrom() != null) {
			criterions.add(Restrictions.ge("price", searchDTO.getPriceFrom()));
		}
		
		if (searchDTO.getPriceTo() != null) {
			criterions.add(Restrictions.le("price", searchDTO.getPriceTo()));
		}

		if (searchDTO.getDesc() != null) {
			criterions.add(Restrictions.ilike("description", searchDTO.getDesc() + "%"));
		}

		return this.getByCriteria(criterions);
	}
}
