package org.gmartin.deofertas.controller;

import org.gmartin.deofertas.service.SuggestedOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuggestedOfferController {
	
	@Autowired(required=true)
	private SuggestedOfferService suggestedOfferService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/suggestion/last",
					method=RequestMethod.GET,
					produces="application/json")
	public ResponseEntity<?> getLastSuggestedOffers(@RequestParam(name="suggestion_id", required=false) Long suggestionId) throws Exception{
		
		return new ResponseEntity(suggestedOfferService.getLastSuggestedOffer(suggestionId), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/suggestion",
					method=RequestMethod.GET,
					produces="application/json")
	public ResponseEntity<?> getSuggestedOffers() throws Exception{
		
		return new ResponseEntity(suggestedOfferService.getSuggestedOffers(), HttpStatus.OK);
	}
}
