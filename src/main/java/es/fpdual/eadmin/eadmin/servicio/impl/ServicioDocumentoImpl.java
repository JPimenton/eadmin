package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

	RepositorioDocumento repositorioDocumento;
	
	@Autowired
	public ServicioDocumentoImpl	(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}
	
	@Override
	public Documento altaDocumento(Documento documento) {
		
		final Documento documentoModificado = 
				obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);
		return documentoModificado;
		/*repositorioDocumento.altaDocumento(documento);
		return documento;*/
	}

	@Override
	public Documento modificaDocumento(Documento documento) {
		
		final Documento documentoModificado = 
				obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.modificaDocumento(documentoModificado);
		return documentoModificado;
	}

	@Override
	public void eliminaDocumento(int Cod) {
		repositorioDocumento.eliminarDocumento(Cod);
		
	}

	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento) {
		return new Documento(
				documento.getCodigo(), 
				documento.getNombre(), 
				dameFechaActual(), 
				documento.getPublico(), 
				documento.getEstado(), 
				documento.getFechaUltimaActualizacion());
	}
	
	protected Date dameFechaActual() {
		return new Date();
	}
}
