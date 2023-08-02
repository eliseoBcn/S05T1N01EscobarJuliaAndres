package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.domain.Sucursal;

 

	
	
	public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
 
		 Optional<Sucursal>   findBynomSucursal(String nomSucursal);
	}
	
 
 