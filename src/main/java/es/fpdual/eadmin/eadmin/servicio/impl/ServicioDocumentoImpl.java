package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
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
				obtenerDocumentoConFechaCorrectaAlta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);
		return documentoModificado;
		
	}

	@Override
	public Documento modificaDocumento(Documento documento) {
		
		final Documento documentoModificado = 
				obtenerDocumentoConFechaCorrectaMod(documento);
		
		repositorioDocumento.modificaDocumento(documentoModificado);
		return documentoModificado;
	}

	@Override
	public void eliminaDocumento(int Cod) {
		repositorioDocumento.eliminarDocumento(Cod);
		
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		return repositorioDocumento.obtenerDocumentoPorCodigo(codigo);
	}

	@Override
	public List<Documento> obtenerListaDocumentos() {
		return repositorioDocumento.obtenerListaDocumentos();
	}

	protected Documento obtenerDocumentoConFechaCorrectaAlta(Documento documento) {

		
		return new DocumentoBuilder().
				conCodigo(documento.getCodigo()).
				conNombre(documento.getNombre()).
				conFechaCreacion(documento.getFechaCreacion()).
				conPublico(documento.getPublico()).
				confechaActualizacion(null).
				conEstado(documento.getEstado()).
				construir();

	}
	
	protected Documento obtenerDocumentoConFechaCorrectaMod(Documento documento) {
	
		return new DocumentoBuilder().clonar(documento).confechaActualizacion(dameFechaActual()).
		construir();
		
	}
	
	protected Date dameFechaActual() {
		return new Date();
	}
}
