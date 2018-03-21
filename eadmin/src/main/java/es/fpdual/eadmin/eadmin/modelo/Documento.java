package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento {
	private int codigo;
	public Documento(int codigo, String nombre, Date fechaCreacion, boolean publico, EstadoDocumento estado) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.publico = publico;
		this.estado = estado;
	}
	private String nombre;
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public boolean isPublico() {
		return publico;
	}
	public EstadoDocumento getEstado() {
		return estado;
	}
	private Date fechaCreacion;
	private boolean publico;
	private EstadoDocumento estado;
	

}
