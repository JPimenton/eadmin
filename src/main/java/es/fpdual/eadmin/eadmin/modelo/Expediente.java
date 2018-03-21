package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
import java.util.List;


public class Expediente extends AdministracionElectronicaBase {

	
	private Date fechaArchivado = null;
	private EstadoExpediente estado;

	private List<Documento> documentos;



	public Expediente(Integer codigo, String nombre, 
			Date fechaCreacion, Boolean publico,EstadoExpediente estado) {
		super(codigo, nombre, fechaCreacion, publico);
		this.estado=estado;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public int hashCode() {
		return getCodigo().hashCode()+getNombre().hashCode()+getFechaCreacion().hashCode()+
				getPublico().hashCode()+estado.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			return getCodigo().equals(((Expediente) obj).getCodigo()) && 
					getNombre().equals(((Expediente) obj).getNombre()) && 
					getFechaCreacion().equals(((Expediente) obj).getFechaCreacion()) &&
					getPublico().equals(((Expediente) obj).getPublico()) &&
					estado.equals(((Expediente) obj).getEstado());
		}
		return false;
	}

	
	
}
