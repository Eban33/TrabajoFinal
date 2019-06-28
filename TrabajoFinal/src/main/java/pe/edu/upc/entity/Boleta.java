package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="boletas")
public class Boleta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBoleta;
	
		@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id",nullable=false)
	private Cliente clienteId;
	
	@Column(name="fecha_Emision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="boleta_id")
	private List<Carrito> carrito;
	
	public Boleta(){
		this.carrito=new ArrayList<>();
	}
	

	@PrePersist
	public void prePersist() {
		fechaEmision = new Date();
	}


	public int getIdBoleta() {
		return idBoleta;
	}


	public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}


	public Cliente getClienteId() {
		return clienteId;
	}


	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}


	public Date getFechaEmision() {
		return fechaEmision;
	}


	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public List<Carrito> getCarrito() {
		return carrito;
	}


	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}
 
	public void addCarrito(Carrito item) {
		this.carrito.add(item);
	}
	public Double getTotal() {

		return carrito.stream().collect(Collectors.summingDouble(Carrito::calcularMontoCarrito));
	}
}