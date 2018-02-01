package org.gmartin.deofertas.service;

import java.util.ArrayList;
import java.util.List;

import org.gmartin.deofertas.dao.IGenericDAO;
import org.gmartin.deofertas.dto.StoreDTO;
import org.gmartin.deofertas.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StoreService {
	@Autowired
	IGenericDAO<Store, Long> storeDAO;
	
	public StoreDTO getStore(Long id) throws Exception{
		
		return storeToStoreDTO(storeDAO.load(id));		
	}
	
	public List<StoreDTO> getStore() throws Exception{
		List<StoreDTO> storesDTO = new ArrayList<StoreDTO>();
		List<Store> stores = storeDAO.getAll();		
		
		for (Store store : stores) {
			storesDTO.add(storeToStoreDTO(store));
		}
		
		return storesDTO;		
	}
	
	private StoreDTO storeToStoreDTO (Store store) {
		StoreDTO storeDTO = new StoreDTO();
		
		storeDTO.setBusinessName(store.getBusinessName());
		storeDTO.setId(store.getId());
		storeDTO.setLogo(store.getLogo());
		
		return storeDTO;
	}
	
	private Store storeDTOToStore (StoreDTO storeDTO) {
		Store store = new Store();
		
		store.setBusinessName(storeDTO.getBusinessName());
		store.setId(storeDTO.getId());
		
		return store;
	}
}
