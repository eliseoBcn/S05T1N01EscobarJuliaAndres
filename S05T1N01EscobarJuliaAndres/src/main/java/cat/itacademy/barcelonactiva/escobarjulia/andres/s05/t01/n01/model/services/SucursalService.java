package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.services;
 


import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.dto.SucursalDTO;

import java.util.List;
import java.util.Optional;



@Service
public interface SucursalService {

 
    /**
     * Retrieve to-do list
     * @return
     */
   List<SucursalDTO> getMySucursalDTOList();
    


    /**
     * retrieve to-do item
     * @param sucursalId
     * @return
     */
     Optional<SucursalDTO> GetSucursalDTOByID(long sucursalId);

    /**
     * Add item to the list and return the id of the new item
     * @param sucursal
     * @return
     */
    long AddItemToThelist(SucursalDTO sucursal);




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
    boolean isSucursalDTOItemIdValid(long sucursalId);
   

    /**
     * returns number of items
     * @return
     */
    long getNumberSucursalDTOItem();


    
}



