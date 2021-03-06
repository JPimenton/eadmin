package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoPropuesta extends Documento {
	private Integer codigoPropuesta;
	private Integer ejercicio;
	private String grupoPolitico;
	
	//Constructor
	public DocumentoPropuesta(Integer codigo, String nombre, Date fechaCreacion, Date fechaActualizacion,
			Boolean publico, EstadoDocumento estado, Integer codigoPropuesta, Integer ejercicio, String grupoPolitico) {
		super(codigo, nombre,fechaCreacion,publico, estado, fechaActualizacion);
		this.codigoPropuesta = codigoPropuesta;
		this.ejercicio = ejercicio;
		this.grupoPolitico = grupoPolitico;
	}

	public Integer getCodigoPropuesta() {
		return codigoPropuesta;
	}
	
	public Integer getEjercicio() {
		return ejercicio;
	}

	public String getGrupoPolitico() {
		return grupoPolitico;
	}
	
	
}