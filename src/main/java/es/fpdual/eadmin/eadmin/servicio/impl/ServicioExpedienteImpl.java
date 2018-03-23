package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioExpediente;

@Service
public class ServicioExpedienteImpl implements ServicioExpediente {

	RepositorioExpediente repositorioExpediente;
	
	@Autowired
	public ServicioExpedienteImpl(RepositorioExpediente repositorioExpediente) {
		this.repositorioExpediente = repositorioExpediente;
	}
	
	@Override
	public Expediente altaExpediente(Expediente expediente) {
		
		final Expediente expedienteModificado = 
				obtenerExpedienteConFechaCorrectaAlta(expediente);
		
		repositorioExpediente.altaExpediente(expedienteModificado);
		return expedienteModificado;
		
		/*repositorioDocumento.altaDocumento(documento);
		return documento;*/
	}

	@Override
	public Expediente modificaExpediente(Expediente expediente) {
		
		final Expediente expedienteModificado = 
				obtenerExpedienteConFechaCorrectaMod(expediente);
		
		repositorioExpediente.modificaExpediente(expedienteModificado);
		return expedienteModificado;
	}

	@Override
	public void eliminaExpediente(int Cod) {
		repositorioExpediente.eliminarExpediente(Cod);
		
	}

	protected Expediente obtenerExpedienteConFechaCorrectaAlta(Expediente documento) {
		/*return new Documento(
				documento.getCodigo(), 
				documento.getNombre(), 
				dameFechaActual(), 
				documento.getPublico(), 
				documento.getEstado(), 
				null);*/
		
		return new ExpedienteBuilder().
				conCodigo(expediente.getCodigo()).
				conNombre(expediente.getNombre()).
				conFechaCreacion(expediente.getFechaCreacion()).
				conPublico(expediente.getPublico()).
				confechaActualizacion(null).
				conEstado(expediente.getEstado()).
				construir();

	}
	
	protected Expediente obtenerExpedienteConFechaCorrectaMod(Expediente expediente) {
		/*return new Documento(
				documento.getCodigo(), 
				documento.getNombre(), 
				documento.getFechaCreacion(), 
				documento.getPublico(), 
				documento.getEstado(), 
				dameFechaActual());*/
		return new ExpedienteBuilder().clonar(expediente).confechaActualizacion(dameFechaActual()).
		construir();
		
	}
	
	protected Date dameFechaActual() {
		return new Date();
	}
}
