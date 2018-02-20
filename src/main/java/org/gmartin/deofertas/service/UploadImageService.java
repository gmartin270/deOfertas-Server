package org.gmartin.deofertas.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.io.IOUtils;
import org.gmartin.deofertas.dao.IGenericDAO;
import org.gmartin.deofertas.dao.IOfferDAO;
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
public class UploadImageService {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	IGenericDAO<OfferImage, Long> offerImageDAO;
	
	@Autowired
	IGenericDAO<SuggestedOffer, Long> suggestedOfferDAO;

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
	
	public void uploadSuggestedImage(SuggestedOfferDTO suggestedOfferDTO) throws Exception{
		
		byte[] img;
		Offer offer = offerDAO.load(suggestedOfferDTO.getOfferId());
		SuggestedOffer suggestedOffer = new SuggestedOffer();
		InputStream is = new FileInputStream(suggestedOfferDTO.getPath());
		
		img = IOUtils.toByteArray(is);
		
		suggestedOffer.setOffer(offer);
		suggestedOffer.setSuggestedImage(img);
		suggestedOffer.setSuggestionDate(sdf.parse(suggestedOfferDTO.getSuggestedDateStr()));
		
		suggestedOfferDAO.saveOrUpdate(suggestedOffer);
	}
}
