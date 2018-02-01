package org.gmartin.deofertas.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.gmartin.deofertas.dao.IGenericDAO;
import org.gmartin.deofertas.dao.IOfferDAO;
import org.gmartin.deofertas.dto.OfferImageDTO;
import org.gmartin.deofertas.model.Offer;
import org.gmartin.deofertas.model.OfferImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UploadImageService {
	@Autowired
	IGenericDAO<OfferImage, Long> offerImageDAO;

	@Autowired
	IGenericDAO<Offer, Long> offerDAO;
	
	public void uploadImage(OfferImageDTO imageDTO) throws Exception{
		
		byte[] img;
		Offer offer = offerDAO.load(imageDTO.getOfferId());
		OfferImage offerImage = new OfferImage();
		InputStream is = new FileInputStream(imageDTO.getPath());
		
		img = IOUtils.toByteArray(is);
		
		offerImage.setOffer(offer);
		offerImage.setImage(img);
		offerImage.setHashId(imageDTO.getHashId());
		
		offerImageDAO.saveOrUpdate(offerImage);
	}
}
