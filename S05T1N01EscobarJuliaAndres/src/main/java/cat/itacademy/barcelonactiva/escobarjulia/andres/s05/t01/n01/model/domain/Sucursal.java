package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sucursal")

public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pk_SucursalID;

	@Column(name = "nomSucursal")
	private String nomSucursal;

	@Column(name = "paisSucursal")
	private int paisSucursal;
	
	public Sucursal() {
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

	public int getPaisSucursal() {
		return paisSucursal;
	}
	public void setPaisSucursal(int paisSucursal) {
		this.paisSucursal = paisSucursal;
	}




}
