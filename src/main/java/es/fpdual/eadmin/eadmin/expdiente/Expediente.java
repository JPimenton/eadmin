package es.fpdual.eadmin.eadmin.expdiente;

import java.util.Date;
import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.*;


public class Expediente {

	private Integer codigo;
	private String nombre;
	private Date fechaCreacion;
	private Date fechaArchivado=null;
	private Boolean publico;
	private EstadoExpediente estado;

	private List<Documento> documentos;

	public Expediente(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,
			EstadoExpediente estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaArchivado = null;
		this.publico = publico;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public int hashCode() {
		return codigo.hashCode()+nombre.hashCode()+fechaCreacion.hashCode()+
				publico.hashCode()+estado.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			return codigo.equals(((Expediente) obj).getCodigo())  && 
					nombre.equals(((Expediente) obj).getNombre()) && 
					fechaCreacion.equals(((Expediente) obj).getFechaCreacion()) &&
					publico.equals(((Expediente) obj).getPublico()) &&
					estado.equals(((Expediente) obj).getEstado());
		}
		return false;
	
	}

	
	
	
}
