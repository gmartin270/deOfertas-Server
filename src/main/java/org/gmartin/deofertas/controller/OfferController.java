package org.gmartin.deofertas.controller;

import org.gmartin.deofertas.dto.SearchDTO;
import org.gmartin.deofertas.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OfferController {
	
	@Autowired(required=true)
	private OfferService offerService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/offer/{id}",
					method=RequestMethod.GET,
					produces="application/json")
	public ResponseEntity<?> getOffer(@PathVariable(required=false) Long id) throws Exception {
		
		return new ResponseEntity(offerService.getOffer(id), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/offer",
					method=RequestMethod.GET,
					produces="application/json")
	public ResponseEntity<?> getOffer(@RequestParam(name="stores", required=false) String stores,
									  @RequestParam(name="title", required=false) String title,
									  @RequestParam(name="desc", required=false) String desc,
									  @RequestParam(name="price_from", required=false) Double priceFrom,
									  @RequestParam(name="price_to", required=false) Double priceTo) throws Exception{
		
		SearchDTO searchDTO = new SearchDTO(title, desc, stores, priceFrom, priceTo);
		
		return new ResponseEntity(offerService.getOffer(searchDTO), HttpStatus.OK);
	}
}
