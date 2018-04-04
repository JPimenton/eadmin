package es.fpdual.admin.eadmin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.EstadoDocumento;
import es.fpdual.admin.eadmin.modelo.EstadoExpediente;
import es.fpdual.admin.eadmin.modelo.Expediente;
import es.fpdual.admin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.admin.eadmin.repositorio.RepositorioExpediente;

@Component
public class CargarDatosIniciales implements ApplicationRunner {
	private final RepositorioDocumento repositorioDocumento;
	private final RepositorioExpediente repositorioExpediente;
	
	private static final Date FECHA = new Date();
	
	@Autowired
	public CargarDatosIniciales (RepositorioDocumento repositorioDocumento,RepositorioExpediente repositorioExpediente) {
		this.repositorioDocumento=repositorioDocumento;
		this.repositorioExpediente=repositorioExpediente;
	}
	
		
	@Override
	public void run(ApplicationArguments args) throws Exception {
			repositorioDocumento.altaDocumento(new Documento (1,"documento1",FECHA,FECHA,true,EstadoDocumento.ACTIVO));
			repositorioDocumento.altaDocumento(new Documento (2,"documento2",FECHA,FECHA,true,EstadoDocumento.ACTIVO));
			repositorioDocumento.altaDocumento(new Documento (3,"documento3",FECHA,FECHA,true,EstadoDocumento.ACTIVO));
			repositorioExpediente.altaExpediente(new Expediente (1,"expediente1",FECHA,FECHA,true,EstadoExpediente.INICIADO,null));
	}
		
}
