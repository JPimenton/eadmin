package es.fpdual.admin.eadmin.modelo.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.EstadoExpediente;
import es.fpdual.admin.eadmin.modelo.Expediente;

public class ExpedienteBuilder {
	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Date fechaUltimaModificacion;
	protected Boolean publico;
	protected Date fechaArchivado= null;
	protected EstadoExpediente estado;
	protected List<Documento> documentos=new ArrayList();
	
	public Expediente build () {
		return new Expediente(codigo,nombre,fechaCreacion,fechaUltimaModificacion,
				publico,estado,documentos);
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
	
	public ExpedienteBuilder conFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion=fechaUltimaModificacion;
		return this;
	}
	
	public ExpedienteBuilder conPublico(boolean publico) {
		this.publico=publico;
		return this;
	}
	
	public ExpedienteBuilder conEstado (EstadoExpediente estado) {
		this.estado=estado;
		return this;
	}
	
	public ExpedienteBuilder conDocumentos (List<Documento> documentos) {
		this.documentos=documentos;
		return this;
	}
	
	public ExpedienteBuilder clonar (Expediente expediente) {
		this.codigo=expediente.getCodigo();
		this.nombre=expediente.getNombre();
		this.fechaCreacion=expediente.getFechaCreacion();
		this.fechaUltimaModificacion=expediente.getFechaUltimaModificacion();
		this.publico=expediente.getPublico();
		this.estado=expediente.getEstado();
		this.documentos=expediente.getDocumentos();
		return this;
	}
	
}
