package es.fpdual.eadmin.eadmin.modelo.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public class ExpedienteBuilder {

	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Boolean publico;
	protected Date fechaUltimaActualizacion;
	protected Date fechaArchivado;
	protected EstadoExpediente estado;
	protected List<Documento> documentos = new ArrayList();;
	
	public Expediente construir(){
		return new Expediente(codigo, nombre, fechaCreacion, publico, estado, fechaUltimaActualizacion, documentos);
	}
	
	public ExpedienteBuilder conCodigo(Integer codigo) {
		this.codigo=codigo;
		return this;
	}
	
	public ExpedienteBuilder conNombre(String nombre) {
		this.nombre=nombre;
		return this;
	}
	
	public ExpedienteBuilder conFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion=fechaCreacion;
		return this;
	}
	
	public ExpedienteBuilder conPublico(Boolean publico) {
		this.publico=publico;
		return this;
	}
	
	public ExpedienteBuilder confechaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion=fechaUltimaActualizacion;
		return this;
	}
	
	public ExpedienteBuilder conEstado(EstadoExpediente estado) {
		this.estado=estado;
		return this;
	}
	
	public ExpedienteBuilder conDocumentos(List<Documento> documentos) {
		this.documentos=documentos;
		return this;
	}
	
	
	public ExpedienteBuilder clonar(Expediente expediente) {
		this.codigo = expediente.getCodigo();
		this.nombre = expediente.getNombre();
		this.fechaCreacion = expediente.getFechaCreacion();
		this.publico = expediente.getPublico();
		this.fechaUltimaActualizacion = expediente.getFechaUltimaActualizacion();
		this.estado = expediente.getEstado();
		this.documentos = expediente.getDocumentos();
		return this;
	}
}
