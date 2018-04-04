package es.fpdual.admin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.Expediente;
import es.fpdual.admin.eadmin.repositorio.RepositorioExpediente;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente {
	
	private List<Expediente> expedientes= new ArrayList<>();

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void altaExpediente(Expediente expediente) {
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException ("El documento ya existe");
		}
		expedientes.add(expediente);
		System.out.println("Se ha insertado un expediente!");
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if(!expedientes.contains(expediente)) {
			throw new IllegalArgumentException ("El documento a modificar no existe");
		}
		expedientes.set(expedientes.indexOf(expediente),expediente);
		
	}
	
	@Override
	public void eliminarExpediente(Integer codigo) {
		 Expediente expedienteEncontrado = expedientes.stream().
					filter(d -> tieneIgualCodigo(d,codigo)).
					findFirst().orElseGet(null);
		
	}

	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		Expediente expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d,codigoExpediente)).
				findFirst().orElseGet(null);
		
			if (expedienteEncontrado != null) {
				expedienteEncontrado.getDocumentos().add(documento);
			}
			
		return null;
	}

	@Override
	public Expediente desasociarDocumentoAlExpediente(Integer codigoExpediente,Integer  codigoDocumento) {
		Expediente expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d,codigoExpediente)).
				findFirst().orElseGet(null);
		if (expedienteEncontrado != null) {
			expedienteEncontrado.getDocumentos().remove(codigoDocumento);
		}
		return null;
	}
	
	protected boolean tieneIgualCodigo(Expediente expediente,Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}
	
	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigo) {
		Optional <Expediente> expedienteEncontrado = expedientes.stream().
				filter(d -> tieneIgualCodigo(d,codigo)).
				findFirst();
		
		if(expedienteEncontrado.isPresent()) {
		return expedienteEncontrado.get();
		}
		
		return null;
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes() {
		return expedientes;
	}

}
