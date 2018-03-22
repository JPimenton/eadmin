package es.fpdual.eadmin.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.*;

public interface RepositorioDocumento {
		
	public abstract void altaDocumento(Documento documento);
	
	public abstract void modificaDocumento(Documento documento);
	
	public abstract void eliminarDocumento(Integer codigo);
	
	public List<Documento> getDocumentos();
}
