package com.famsa.examen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "pendiente")
public class Pendiente implements Serializable{
	
	/**
	 * Autor: Daniel Benitez Alejandro 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPendiente;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	public Pendiente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pendiente(Long idPendiente, String nombre, String descripcion, Date fecha) {
		super();
		this.idPendiente = idPendiente;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}


	public Long getIdPendiente() {
		return idPendiente;
	}
	public void setIdPendiente(Long idPendiente) {
		this.idPendiente = idPendiente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
