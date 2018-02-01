package org.gmartin.deofertas.dao;

import java.util.List;

import org.gmartin.deofertas.model.OfferImage;

public interface IOfferImageDAO extends IGenericDAO<OfferImage, Long>{

	public List<OfferImage> getOfferImageByCriteria(OfferImage offerImage);
}