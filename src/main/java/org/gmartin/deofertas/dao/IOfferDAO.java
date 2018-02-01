package org.gmartin.deofertas.dao;

import java.util.List;

import org.gmartin.deofertas.dto.SearchDTO;
import org.gmartin.deofertas.model.Offer;

public interface IOfferDAO extends IGenericDAO<Offer, Long>{

	public List<Offer> getOfferByCriteria(SearchDTO searchDTO);
}
