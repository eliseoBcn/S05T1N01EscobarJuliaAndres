package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.dto;

 
public class SucursalDTO {
/*  Pojo entidad Sucursal + tipoSucursal */ 
	private long pk_SucursalID;

	private String nomSucursal;

	private String  paisSucursal;

	private String tipusSucursal;
	
	private String[] listaPaises= {
			"Alemania", "Belgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia", 
			"Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
			"Polonia", "Republica Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia", 
			"Lituania", "Portugal","Rumanía"};

	public SucursalDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getPk_SucursalID() {
		return pk_SucursalID;
	}
	public void setPk_SucursalID(long pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}


	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String  getPaisSucursal() {
		return paisSucursal;
	}
	public void setPaisSucursal(String  paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	public String getTipusSucursal( ) {
		return tipusSucursal;
	}
	public void  setTipoSucursal(String paisSucursal) {
		tipusSucursal = "Fora UE";
		
		int i = 0;
		while (i  < listaPaises.length && tipusSucursal.equals("Fora UE") ) {
			
			if( paisSucursal.equalsIgnoreCase(listaPaises[i])) {
				tipusSucursal = "UE";
			}
 		  i++;
		}
		
		
	}
	



}
