package es.fpdual.eadmin.eadmin.repositorio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;


public interface  RepositorioExpediente {

	public abstract void altaExpediente(Expediente expediente);
	
	public abstract void modificaExpediente(Expediente expediente);
	
	public abstract void eliminarExpediente(Integer codigo);
	
	public List<Expediente> getExpedientes();
	
	public void asociarDocumentoAExpediente(Expediente expediente, Documento documento);
	
	public void desasociarDocumentoAExpediente(Expediente expediente, Documento documento);
}
