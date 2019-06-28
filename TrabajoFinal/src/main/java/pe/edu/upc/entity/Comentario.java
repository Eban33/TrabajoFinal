package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="comentarios")
public class Comentario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComentario;
	
	@NotEmpty(message="Escriba un comentario del producto")
	@Column(name="descripcionComentario",nullable=false,length=100)
	private String descripcionComentario;
	
	@NotNull(message="Seleccione el producto que desee comentar")
	@ManyToOne
	@JoinColumn(name="Producto_id")
	private Producto producto;
	
	@NotNull(message="Seleccione el cliente que desee comentar")
    @ManyToOne
    @JoinColumn(name="Cliente_id")
	private Cliente cliente;
    
    @Min(1)
    @Max(5)
    private int valoracion;


	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comentario(int idComentario, String descripcionComentario, Producto producto,int valoracion,Cliente cliente) {
		super();
		this.idComentario = idComentario;
		this.descripcionComentario = descripcionComentario;
		this.producto = producto;
		this.valoracion=valoracion;
	
	}


	public int getIdComentario() {
		return idComentario;
	}


	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}


	public String getDescripcionComentario() {
		return descripcionComentario;
	}


	public void setDescripcionComentario(String descripcionComentario) {
		this.descripcionComentario = descripcionComentario;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getValoracion() {
		return valoracion;
	}


	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}







