package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carritos")
public class Carrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	
	private int cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idProducto")
	private Producto idProducto;

	public Carrito(int idCarrito, int cantidad, Producto idProducto) {
		super();
		this.idCarrito = idCarrito;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
	}

	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}
	
	public Double calcularMontoCarrito() {
		return cantidad*idProducto.getPrecioProducto()*(1-(idProducto.getCampana().getDescuentoCampana()));
	}
	

}
