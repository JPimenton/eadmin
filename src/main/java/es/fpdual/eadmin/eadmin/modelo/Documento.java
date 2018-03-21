package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends AdministracionElectronicaBase {

	private EstadoDocumento estado;

	
	public Documento(Integer codigo, String nombre,
			Date fechaCreacion, Boolean publico,EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, publico);
		
		
	}

	public EstadoDocumento getEstado() {
		return estado;
	}
	

}
