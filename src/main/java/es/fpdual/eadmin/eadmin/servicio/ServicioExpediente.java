package es.fpdual.eadmin.eadmin.servicio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface ServicioExpediente {

	Expediente altaExpediente(Expediente expediente);

	Expediente modificaExpediente(Expediente expediente);
	
	void eliminaExpediente(int Cod);
	
}
