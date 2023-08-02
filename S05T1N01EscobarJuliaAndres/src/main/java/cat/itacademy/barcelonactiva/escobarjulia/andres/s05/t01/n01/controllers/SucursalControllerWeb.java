package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.servlet.ModelAndView;



import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.domain.Sucursal;
 import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.services.SucursalService;

@Controller
@RequestMapping("/sucursales")
public class SucursalControllerWeb {
	@Autowired
	SucursalService sucursalService;
	
	@GetMapping({"/listado", "/"})
	public String listar( Model modelo ) {
		List<SucursalDTO> listasucursales  =  sucursalService.getListaSucursales();
		if ( listasucursales .size() > 0 ) {
			modelo.addAttribute("sucursales",listasucursales );
		}
		
		
		return "listado";
	}
	
	@RequestMapping("/alta")
	   public String   newSucursal(Model modelo ) {

		SucursalDTO sucursal = new SucursalDTO();
		modelo.addAttribute("operacion","alta" );
 		modelo.addAttribute("error"," " );
		modelo.addAttribute("sucursal",sucursal );
	        
	        return "alta";
	    }

	@PostMapping("/guardar")
	   public String   Guardar(@ModelAttribute("sucursal") SucursalDTO sucursaldto,Model modelo )  {

        boolean existesucursal  = sucursalService.findBynomSucursal(sucursaldto.getNomSucursal());
        if( existesucursal) {
    		modelo.addAttribute("error","Nombre Sucursal ya existente. " );
    		modelo.addAttribute("sucursal", sucursaldto );
 
	        return  "alta";        	
    
 
        }
        
        long sucursalId = sucursalService.AltaSucursal(sucursaldto);
        return "redirect:/sucursales/listado"; 
	
	}
	  
	@PostMapping("/actualizar")
	   public String   actualizar(@ModelAttribute("sucursal") SucursalDTO sucursaldto,Model modelo )  {

//     boolean existesucursal  = sucursalService.findBynomSucursal(sucursaldto.getNomSucursal());
//     if( existesucursal) {
// 		modelo.addAttribute("error","Nombre Sucursal ya existente. " );
// 		modelo.addAttribute("sucursal", sucursaldto );
//
//	        return  "modificar";        	
 
//     }
     
     long sucursalId = sucursalService.UpdateSucursalDTOItem(sucursaldto.getPk_SucursalID() ,sucursaldto);
     return "redirect:/sucursales/listado"; 
	
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminarByID(@PathVariable("id")  long id) {
		Optional<SucursalDTO> sucursalData = sucursalService.GetSucursalDTOByID(id);
		System.out.println("delete ");
		if (sucursalData.isPresent()) {
			sucursalService.DeleteItem(id);
		} 
        return "redirect:/sucursales/listado";
 
	}
	@RequestMapping("/actualizar/{id}")
	public String actualizarByID(@PathVariable("id")  long id, Model modelo  ) {
		Optional<SucursalDTO> sucursaldto = sucursalService.GetSucursalDTOByID(id);
		if (sucursaldto.isPresent()) {
			modelo.addAttribute("sucursal", sucursaldto);
		} 

		
 
        return "modificar";
 
	}
}
