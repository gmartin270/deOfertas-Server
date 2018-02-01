package org.gmartin.deofertas.controller;

import org.gmartin.deofertas.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreController {
	
	@Autowired(required=true)
	private StoreService storeService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/store/{id}",
					method=RequestMethod.GET,
					produces="application/json")
	public ResponseEntity<?> getOffer(@PathVariable(required=false) Long id) throws Exception {
		
		return new ResponseEntity(storeService.getStore(id), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/store",
					method=RequestMethod.GET,
					produces="application/json")
	public ResponseEntity<?> getOffer() throws Exception{
		
		return new ResponseEntity(storeService.getStore(), HttpStatus.OK);
	}
}
