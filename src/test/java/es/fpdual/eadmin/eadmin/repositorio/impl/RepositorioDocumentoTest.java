package es.fpdual.eadmin.eadmin.repositorio.impl;
import java.util.Date;
import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.*;
import es.fpdual.eadmin.eadmin.repositorio.*;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RepositorioDocumentoTest {

	private Documento doc;
	private RepositorioDocumento RepositorioDocumentos;
	
	@Before
	public void Inicializar() {
	doc = new Documento(1,"Registro de prueba",new Date(),
			false,EstadoDocumento.ACTIVO,new Date(8/8/2003));
	
	RepositorioDocumentos = new RepositorioDocumentoImpl();
	}
	
	@Test 
	public void altaDocumentosTest()  {
		RepositorioDocumentos.altaDocumento(doc);
		assertTrue(RepositorioDocumentos.obtenerListaDocumentos().contains(doc));
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
		
		assertTrue(RepositorioDocumentos.obtenerListaDocumentos().
				get(RepositorioDocumentos.obtenerListaDocumentos().
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
		assertTrue(RepositorioDocumentos.obtenerListaDocumentos().isEmpty());
			
	}
	
	@Test (expected=NullPointerException.class)
	public void EliminarDocumentoTestFail(){
		RepositorioDocumentos.altaDocumento(doc);
		Documento doc2 = new Documento(2,"Registro de prueba",new Date(),
				false,EstadoDocumento.APROBADO,new Date(8/8/2003));
		RepositorioDocumentos.eliminarDocumento(doc2.getCodigo());
		
	}
	
	@Test 
	public void obtenerDocumentoPorCodigo(){
		RepositorioDocumentos.altaDocumento(doc);
		Documento doc2 = RepositorioDocumentos.obtenerDocumentoPorCodigo(doc.getCodigo());
		assertTrue(doc2.equals(doc));
			
	}
	
	@Test (expected=NullPointerException.class)
	public void obtenerDocumentoPorCodigoFail(){
		Documento doc2 = RepositorioDocumentos.obtenerDocumentoPorCodigo(doc.getCodigo());
		assertNull(doc2);					
	}
	
	@Test 
	public void obtenerDocumentos(){
		RepositorioDocumentos.altaDocumento(doc);
		List<Documento> Resultado = RepositorioDocumentos.obtenerListaDocumentos();
		assertEquals(Resultado, RepositorioDocumentos.obtenerListaDocumentos());
			
	}

	
}