package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.services;
 


import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.domain.Sucursal;

import java.util.List;
import java.util.Optional;



@Service
public interface SucursalService {

 
 
   List<SucursalDTO> getListaSucursales();
 
   Optional<SucursalDTO> GetSucursalDTOByID(long sucursalId);

    /**
     * Add item to the list and return the id of the new item
     * @param sucursal
     * @return
     */
    long AltaSucursal(SucursalDTO sucursal);




    /**
     * Delete item from the list
     * @param id
     */
     void DeleteItem(long id);
    
    /**
     * Update to-do item
     * @param sucursalId
     * @param sucursal
     * @return
     */
    long UpdateSucursalDTOItem(long sucursalId, SucursalDTO sucursal);

    /**
     * Verify if the id provided is valid
     * @param sucursalId
     * @return
     */
    boolean existeSucursalByID(long sucursalId);
   

    /**
     * returns number of items
     * @return
     */
    long getNumberSucursalDTOItem();



	 boolean findBynomSucursal(String nomSucursal);
	
}



