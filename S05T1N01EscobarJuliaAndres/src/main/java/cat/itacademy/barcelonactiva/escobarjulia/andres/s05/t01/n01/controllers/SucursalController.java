package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.services.SucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
 
	/*
	*/
	@Autowired
	SucursalService sucursalService;
		
	@PostMapping("/add")
	public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursaldto) {
        long sucursalId = 0;
        sucursalId = sucursalService.AltaSucursal(sucursaldto);
        if(sucursalId>0){
    		Optional<SucursalDTO> sucursal  = sucursalService.GetSucursalDTOByID(sucursalId);
    		if (sucursal.isPresent()) {
    			// En el ejercicio pasado no se devolvia el  json con el id sino el objeto de entrada
    			return new ResponseEntity<>(sucursal.get(), HttpStatus.CREATED);
    		}
    	}
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> DeleteId(@PathVariable("id") long id) {
		Optional<SucursalDTO> sucursalData = sucursalService.GetSucursalDTOByID(id);
		System.out.println("delete ");
		if (sucursalData.isPresent()) {
			sucursalService.DeleteItem(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable("id") long id, @RequestBody SucursalDTO sucursal) {
	
    //verify if the id provided is valid before update
    boolean isTodoIdValid=sucursalService.existeSucursalByID(id);

		    if(isTodoIdValid){
		        long sucursalId=0;
		        sucursalId=sucursalService.UpdateSucursalDTOItem(id,sucursal);
		
		        if(sucursalId>0){
					return new ResponseEntity<>(sucursal , HttpStatus.OK);
		        }else{
		            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		        }
		
		    }else {
		 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<SucursalDTO>> getAllSucursals(@RequestParam(required = false) String nombre) {
		
			List<SucursalDTO> sucursal  =  sucursalService.getListaSucursales();
			if ( sucursal.size() > 0 ) {
				return new ResponseEntity<>( sucursalService.getListaSucursales() , HttpStatus.OK);
			}else {
		        return new ResponseEntity(HttpStatus.NOT_FOUND) ;
			}
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<SucursalDTO> getSucursalById(@PathVariable("id") long id) {
		Optional<SucursalDTO> sucursalData = sucursalService.GetSucursalDTOByID(id);

		if (sucursalData.isPresent()) {
			return new ResponseEntity<>(sucursalData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
