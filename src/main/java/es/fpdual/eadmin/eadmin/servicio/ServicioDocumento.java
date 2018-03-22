package es.fpdual.eadmin.eadmin.servicio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {

	void altaDocumento(Documento documento);

	Documento modificaDocumento(Documento documento);
	
	void eliminaDocumento(int Cod);
	
}
