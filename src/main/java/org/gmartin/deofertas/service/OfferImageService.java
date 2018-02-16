package org.gmartin.deofertas.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;

import org.gmartin.deofertas.dao.IGenericDAO;
import org.gmartin.deofertas.dao.IOfferImageDAO;
import org.gmartin.deofertas.dao.OfferImageDAO;
import org.gmartin.deofertas.dto.OfferImageDTO;
import org.gmartin.deofertas.model.Offer;
import org.gmartin.deofertas.model.OfferImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OfferImageService {
	@Autowired
	IGenericDAO<OfferImage, Long> offerImageDAO;
	
	@Autowired
	IGenericDAO<Offer, Long> offerDAO;
	
	IOfferImageDAO customOfferImage;
	
	@PostConstruct
	public void init(){
		customOfferImage = (OfferImageDAO)offerImageDAO;
	}
	
	public OfferImageDTO getOfferImage(Long id) throws Exception{
		
		return offerImageToOfferImageDTO(offerImageDAO.load(id));		
	}
	
	public List<OfferImageDTO> getOfferImages(OfferImageDTO offerImageDTO) throws Exception{
		List<OfferImageDTO> offerImagesDTO = new ArrayList<OfferImageDTO>();
		List<OfferImage> offerImages = null;
		OfferImage offerImage = null;
		
		offerImage = offerImageDTOToOfferImage(offerImageDTO);
		
		if (offerImageDTO.getOfferId() != null) {
			Offer offer = offerDAO.load(offerImageDTO.getOfferId());
			offerImage.setOffer(offer);
		}
		
		offerImages = customOfferImage.getOfferImageByCriteria(offerImage);
		
		for (OfferImage image: offerImages) {
			offerImagesDTO.add(offerImageToOfferImageDTO(image));
		}
		
		return offerImagesDTO;		
	}
	
	private OfferImageDTO offerImageToOfferImageDTO (OfferImage offerImage) {
		OfferImageDTO offerImageDTO = new OfferImageDTO();
		
		offerImageDTO.setHashId(offerImage.getHashId());
		offerImageDTO.setId(offerImage.getId());
		offerImageDTO.setImage(Base64.getEncoder().encodeToString(offerImage.getImage()));
		offerImageDTO.setOfferId(offerImage.getOffer().getId());
		
		return offerImageDTO;
	}
	
	private OfferImage offerImageDTOToOfferImage (OfferImageDTO offerImageDTO) {
		OfferImage offerImage = new OfferImage();
		
		offerImage.setHashId(offerImageDTO.getHashId());
		offerImage.setHashId(offerImageDTO.getHashId());
		
		return offerImage;
	}
}
