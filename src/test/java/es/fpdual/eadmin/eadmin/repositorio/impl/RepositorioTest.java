package es.fpdual.eadmin.eadmin.repositorio.impl;
import java.util.Date;

import es.fpdual.eadmin.eadmin.modelo.*;
import es.fpdual.eadmin.eadmin.repositorio.*;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class RepositorioTest {

	private Documento doc;
	private RepositorioDocumento RepositorioDocumentos;
	
	@Before
	public void Inicializar() {
	doc = new Documento(1,"Registro de prueba",new Date(),
			false,EstadoDocumento.ACTIVO,new Date(8/8/2003));
	
	RepositorioDocumentos = new RepositorioDocumentoImpl();
	}
	
	@Test 
	public void altaDocumentosAlta()  {
		RepositorioDocumentos.altaDocumento(doc);
		assertTrue(RepositorioDocumentos.getDocumentos().contains(doc));
	}	
	
	@Test (expected=IllegalArgumentException.class)
	public void altaDocumentosAltaFail() {	
		RepositorioDocumentos.altaDocumento(doc);
		RepositorioDocumentos.altaDocumento(doc);
	}

	@Test
	public void ModificarDocumentoTest(){
		RepositorioDocumentos.altaDocumento(doc);
		
		Documento doc2 = new Documento(1,"Registro de prueba",new Date(),
				false,EstadoDocumento.APROBADO,new Date(8/8/2003));
		
		RepositorioDocumentos.modificaDocumento(doc2);
		
		assertTrue(RepositorioDocumentos.getDocumentos().
				get(RepositorioDocumentos.getDocumentos().
				indexOf(doc)).getEstado()==doc2.getEstado());
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void ModificarDocumentoTestFail(){
		RepositorioDocumentos.altaDocumento(doc);
		
		Documento doc2 = new Documento(2,"Registro de prueba",new Date(),
				false,EstadoDocumento.APROBADO,new Date(8/8/2003));
		
		RepositorioDocumentos.modificaDocumento(doc2);
			
	}
	
	@Test 
	public void EliminarDocumentoTest(){
		RepositorioDocumentos.altaDocumento(doc);
		RepositorioDocumentos.eliminarDocumento(doc.getCodigo());
		assertTrue(RepositorioDocumentos.getDocumentos().isEmpty());
			
	}
	
	@Test (expected=NullPointerException.class)
	public void EliminarDocumentoTestFail(){
		RepositorioDocumentos.altaDocumento(doc);
		Documento doc2 = new Documento(2,"Registro de prueba",new Date(),
				false,EstadoDocumento.APROBADO,new Date(8/8/2003));
		RepositorioDocumentos.eliminarDocumento(doc2.getCodigo());
		
	}
	
}