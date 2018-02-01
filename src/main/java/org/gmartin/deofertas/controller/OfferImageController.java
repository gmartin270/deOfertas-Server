package org.gmartin.deofertas.controller;

import org.gmartin.deofertas.dto.OfferImageDTO;
import org.gmartin.deofertas.service.OfferImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OfferImageController {
	
	@Autowired(required=true)
	private OfferImageService offerImageService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/offerImage/{id}",
					method=RequestMethod.GET,
					produces="application/json")
	public ResponseEntity<?> getOfferImage(@PathVariable(required=false) Long id) throws Exception {
		
		return new ResponseEntity(offerImageService.getOfferImage(id), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/offerImage",
					method=RequestMethod.GET,
					produces="application/json")
	public ResponseEntity<?> getOfferImages(@RequestParam(name="id", required=false) Long id,
										    @RequestParam(name="hash_id", required=false) String hashId,
										    @RequestParam(name="offer_id", required=false) Long offerId) throws Exception{
		
		OfferImageDTO offerImageDTO = new OfferImageDTO(id, offerId, hashId, null);
		return new ResponseEntity(offerImageService.getOfferImages(offerImageDTO), HttpStatus.OK);
	}
}
