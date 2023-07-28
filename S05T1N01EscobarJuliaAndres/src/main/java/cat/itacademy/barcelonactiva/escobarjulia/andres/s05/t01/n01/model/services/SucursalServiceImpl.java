package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.repository.SucursalRepository;




@Service
public class SucursalServiceImpl implements SucursalService {
	
    private static Logger logger=Logger.getLogger(SucursalServiceImpl.class.getName());
    @Autowired
    private SucursalRepository sucursalRepository;
	public SucursalServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SucursalDTO> getMySucursalDTOList() {
		// TODO Auto-generated method stub
        List<Sucursal> sucursal1      = new ArrayList<>();
        List<SucursalDTO> sucursalDTO = new ArrayList<>();
   
        
        
        List<Sucursal> todoList= new ArrayList<>();
        sucursalRepository.findAll().forEach(todoList::add);

//        return  todoList;
 
        for ( Sucursal sucursal : todoList) {
   
        	
        	
 		   SucursalDTO   sucursaldto =  new SucursalDTO(); 
 			
 			   sucursaldto.setNomSucursal(sucursal.getNomSucursal());
 			   sucursaldto.setPaisSucursal(sucursal.getPaisSucursal());
   	           sucursaldto.setPk_SucursalID(sucursal.getPk_SucursalID());
 		       sucursalDTO.add(sucursaldto);
 		       sucursaldto = null;
        	
        	
        	
        }
        return  sucursalDTO;
	}

	@Override
	public Optional<SucursalDTO> GetSucursalDTOByID(long sucursalId) {
		// TODO Auto-generated method stub
		
		Optional<Sucursal> sucursal  =  sucursalRepository.findById(sucursalId);
		SucursalDTO sucursaldto =  new SucursalDTO();
		
		if (sucursal.isPresent()) {
 
			sucursaldto.setNomSucursal( sucursal.get().getNomSucursal());
			
			sucursaldto.setPaisSucursal(sucursal.get().getPaisSucursal());
			sucursaldto.setPk_SucursalID(sucursalId);;
					
			return Optional.of(sucursaldto);
		} 
		return Optional.empty();
		
		

	}

	@Override
	public long AddItemToThelist(SucursalDTO sucursal) {
		// TODO Auto-generated method stub
				
		   Sucursal  sucursal2  =  new Sucursal(); 
		
		   sucursal2.setNomSucursal(sucursal.getNomSucursal());
		   sucursal2.setPaisSucursal(sucursal.getPaisSucursal());
//		   sucursal2.setPk_SucursalID(getNumberSucursalDTOItem());
	       long sucursalId=0;
	        sucursalRepository.save(sucursal2);
	        sucursalId=sucursal2.getPk_SucursalID();
	        sucursal.setPk_SucursalID(sucursalId);
	        return sucursalId;
  
	}

	@Override
	public void DeleteItem(long id) {
		// TODO Auto-generated method stub
        long itemId=0;
        sucursalRepository.deleteById(id);
        logger.info("Item removed from the list");
	}

	@Override
	public long UpdateSucursalDTOItem(long sucursalId, SucursalDTO sucursal) {
		// TODO Auto-generated method stub
		Optional<Sucursal> sucursalrespositorio  =  sucursalRepository.findById(sucursalId);
//		SucursalDTO sucursaldto =  new SucursalDTO();
		
		if (sucursalrespositorio.isPresent()) {
 
			sucursalrespositorio.get().setNomSucursal( sucursal.getNomSucursal());
			
			sucursalrespositorio.get().setPaisSucursal(sucursal.getPaisSucursal());
//			sucursaldto.setPk_SucursalID(sucursalId);;
					
	        sucursalRepository.save(sucursalrespositorio.get());	
	        		return 1;
		} 
		return 0;
		
	}

	@Override
	public boolean isSucursalDTOItemIdValid(long sucursalId) {
		// TODO Auto-generated method stub
		 return sucursalRepository.findById(sucursalId).isPresent();
	}

	@Override
	public long getNumberSucursalDTOItem() {
		// TODO Auto-generated method stub
	      return sucursalRepository.count();
	}

}
