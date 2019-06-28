package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "campanas")
public class Campana implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCampana;

	@NotEmpty(message="Debe ingresar el nombre de la campana")
	@Column(name="nombreCampana",nullable=false,length=45,unique=true)
	private String nombreCampana;

	@NotNull(message="La fecha es obligatoria")
	@Past(message="La fecha debe estar en pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fechaInicioCampana")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaInicioCampana;
	
	@NotNull(message="La fecha es obligatoria")
	@Future(message="La fecha debe estar en futuro")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fechaFinCampana")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaFinCampana;
	
	private double descuentoCampana;

	public Campana() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Campana(int idCampana, @NotEmpty(message = "Debe ingresar el nombre de la campana") String nombreCampana,
			@NotNull(message = "La fecha es obligatoria") @Past(message = "La fecha debe estar en pasado") Date fechaInicioCampana,
			@NotNull(message = "La fecha es obligatoria") @Future(message = "La fecha debe estar en futuro") Date fechaFinCampana,
			double descuentoCampana) {
		super();
		this.idCampana = idCampana;
		this.nombreCampana = nombreCampana;
		this.fechaInicioCampana = fechaInicioCampana;
		this.fechaFinCampana = fechaFinCampana;
		this.descuentoCampana = descuentoCampana;
	}



	public int getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(int idCampana) {
		this.idCampana = idCampana;
	}

	public String getNombreCampana() {
		return nombreCampana;
	}

	public void setNombreCampana(String nombreCampana) {
		this.nombreCampana = nombreCampana;
	}

	public Date getFechaInicioCampana() {
		return fechaInicioCampana;
	}

	public void setFechaInicioCampana(Date fechaInicioCampana) {
		this.fechaInicioCampana = fechaInicioCampana;
	}

	public Date getFechaFinCampana() {
		return fechaFinCampana;
	}

	public void setFechaFinCampana(Date fechaFinCampana) {
		this.fechaFinCampana = fechaFinCampana;
	}
	
	

	public double getDescuentoCampana() {
		return descuentoCampana;
	}



	public void setDescuentoCampana(double descuentoCampana) {
		this.descuentoCampana = descuentoCampana;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCampana;
		result = prime * result + ((nombreCampana == null) ? 0 : nombreCampana.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campana other = (Campana) obj;
		if (idCampana != other.idCampana)
			return false;
		if (nombreCampana == null) {
			if (other.nombreCampana != null)
				return false;
		} else if (!nombreCampana.equals(other.nombreCampana))
			return false;
		return true;
	}

}
