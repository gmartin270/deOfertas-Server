package org.gmartin.deofertas.controller;

import org.gmartin.deofertas.dto.OfferImageDTO;
import org.gmartin.deofertas.dto.ResponseStatus;
import org.gmartin.deofertas.dto.SuggestedOfferDTO;
import org.gmartin.deofertas.service.UploadImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UploadImageController {
	
	@Autowired(required=true)
	private UploadImageService uploadService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/upload",
					method=RequestMethod.POST,
					produces="application/json")
	public ResponseEntity<?> uploadImage(@RequestBody OfferImageDTO imageDTO ) throws Exception {
		
		uploadService.uploadImage(imageDTO);
		
		return new ResponseEntity(new ResponseStatus(), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/uploadSuggestion",
					method=RequestMethod.POST,
					produces="application/json")
	public ResponseEntity<?> uploadSuggestedOffer(@RequestBody SuggestedOfferDTO suggestedOfferDTO) throws Exception {
		
		uploadService.uploadSuggestedImage(suggestedOfferDTO);
		
		return new ResponseEntity(new ResponseStatus(), HttpStatus.OK);
	}
}
