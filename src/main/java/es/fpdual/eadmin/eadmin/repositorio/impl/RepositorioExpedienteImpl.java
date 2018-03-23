package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.*;

@Component
public class RepositorioExpedienteImpl implements RepositorioExpediente {
	
	private List<Expediente> expediente = new ArrayList<>();

	@Override
	public void altaExpediente(Expediente expediente) {
		if(this.expediente.contains(expediente)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		this.expediente.add(expediente);
	}

	@Override
	public void modificaExpediente(Expediente expediente) {
		if (!this.expediente.contains(expediente)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		final Expediente expedienteNuevo = obtenerExpedienteConFechaDeModificacion(expediente);
		this.expediente.set(this.expediente.indexOf(expediente), expedienteNuevo);
	}
	
	protected Expediente obtenerExpedienteConFechaDeModificacion(Expediente expediente) {
		return new Expediente(
				expediente.getCodigo(), 
				expediente.getNombre(), 
				new Date(), 
				expediente.getPublico(), 
				expediente.getEstado(), 
				expediente.getFechaUltimaActualizacion());
		
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		Expediente expedienteEncontrado = null;
		
		/* for(int i = 0; i< documentos.size(); i++) {
			if ( documentos.get(i).getCodigo().equals(codigo)) {
				documentoEncontrado = documentos.get(i);
				break;
			}
		}*/
		
		expedienteEncontrado =
		expediente.stream().filter(e -> e.getCodigo().equals(expediente)).
		findFirst().orElseGet(null);
		
		if (Objects.nonNull(expedienteEncontrado)) {
			expediente.remove(expedienteEncontrado);
		}
	}
	
	@Override
	public List<Expediente> getExpedientes() {
		return expediente;
	}

	@Override
	public void asociarDocumentoAExpediente(Expediente expediente, Documento documento) {
		
		this.getExpedientes().get(this.getExpedientes().indexOf(expediente)).getDocumentos().add(documento);
		
		
	}

	@Override
	public void desasociarDocumentoAExpediente(Expediente expediente, Documento documento) {
		this.getExpedientes().get(this.getExpedientes().indexOf(expediente)).getDocumentos().
		remove(
		this.getExpedientes().get(this.getExpedientes().indexOf(expediente)).getDocumentos().indexOf(documento));
		
	}

}
