package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.*;

@Component
public class RepositorioDocumentoImpl implements RepositorioDocumento {
	
	private List<Documento> documentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {
		if(documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);
	}

	@Override
	public void modificaDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		final Documento documentoNuevo = obtenerDocumentoConFechaDeModificacion(documento);
		documentos.set(documentos.indexOf(documento), documentoNuevo);
	}
	
	protected Documento obtenerDocumentoConFechaDeModificacion(Documento documento) {
		return new Documento(
				documento.getCodigo(), 
				documento.getNombre(), 
				new Date(), 
				documento.getPublico(), 
				documento.getEstado(), 
				documento.getFechaUltimaActualizacion());
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		Documento documentoEncontrado = null;
		
		/* for(int i = 0; i< documentos.size(); i++) {
			if ( documentos.get(i).getCodigo().equals(codigo)) {
				documentoEncontrado = documentos.get(i);
				break;
			}
		}*/
		
		documentoEncontrado =
		documentos.stream().filter(d -> d.getCodigo().equals(codigo)).
		findFirst().orElseGet(null);
		
		if (Objects.nonNull(documentoEncontrado)) {
			documentos.remove(documentoEncontrado);
		}
	}
	
	@Override
	public List<Documento> getDocumentos() {
		return documentos;
	}

}
