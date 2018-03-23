package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends AdministracionElectronicaBase {

	private final EstadoDocumento estado;

	
	public Documento(Integer codigo, String nombre,
			Date fechaCreacion, Boolean publico,EstadoDocumento estado, Date fechaActualizacion) {
		super(codigo, nombre, fechaCreacion, publico,fechaActualizacion);
		this.estado = estado;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}
	
}