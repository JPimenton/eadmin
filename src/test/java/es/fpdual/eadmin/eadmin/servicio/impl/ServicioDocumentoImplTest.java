package es.fpdual.eadmin.eadmin.servicio.impl;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

public class ServicioDocumentoImplTest {

	private ServicioDocumento ServicioDocumento;
	private static final Documento DOCUMENTO = mock(Documento.class);
	//private static final Documento DOCUMENTO = new Documento(1,"nombre",new Date(),false,EstadoDocumento.ACTIVO);
	private final RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	//private RepositorioDocumentoImpl repositorioDocumento;
	
	
	@Before
	public void inicializarEnCadaTest() {
		//this.repositorioDocumento = new RepositorioDocumentoImpl();
		this.ServicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
		
	}
	
	@Test
	public void deberiaAlmacenarUnDocumento() {
		when (DOCUMENTO.getCodigo()).thenReturn(1);
		when (DOCUMENTO.getFechaCreacion()).thenReturn(new Date(1/1/2018));
		when (DOCUMENTO.getNombre()).thenReturn("nombre");
		
		final Documento resultado = this.ServicioDocumento.altaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(any());
		//assertEquals(1, this.repositorioDocumento.getDocumentos().size());
		assertEquals(resultado.getCodigo(),DOCUMENTO.getCodigo());
		assertEquals(resultado.getNombre(),DOCUMENTO.getNombre());
		assertNotEquals(resultado.getFechaCreacion(),DOCUMENTO.getFechaCreacion());
		assertEquals(resultado,DOCUMENTO);
		
		/*
		this.ServicioDocumento.altaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(DOCUMENTO);
		//assertEquals(1, this.repositorioDocumento.getDocumentos().size());*/
	}
	
	@Test
	public void deberiaModificarUnDocumento() {
		when (DOCUMENTO.getCodigo()).thenReturn(1);
		when (DOCUMENTO.getFechaCreacion()).thenReturn(new Date(1/1/2018));
		when (DOCUMENTO.getNombre()).thenReturn("nombre");
		
		final Documento resultado = this.ServicioDocumento.modificaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).modificaDocumento(any());
		//assertEquals(1, this.repositorioDocumento.getDocumentos().size());
		assertEquals(resultado.getCodigo(),DOCUMENTO.getCodigo());
		assertEquals(resultado.getNombre(),DOCUMENTO.getNombre());
		assertNotEquals(resultado.getFechaCreacion(),DOCUMENTO.getFechaCreacion());
		assertEquals(resultado,DOCUMENTO);
	}
	
	
	@Test
	public void deberiaEliminarUnDocumento() {
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		
		this.ServicioDocumento.eliminaDocumento(DOCUMENTO.getCodigo());
		
		verify(this.repositorioDocumento).eliminarDocumento(DOCUMENTO.getCodigo());
		//assertEquals(1, this.repositorioDocumento.getDocumentos().size());
	}
	
	@Test
	public void deberiaObtenerUnDocumentoPorCodigo() {
		when (this.repositorioDocumento.obtenerDocumentoPorCodigo(1)).thenReturn(DOCUMENTO);
		final Documento resultado = this.ServicioDocumento.obtenerDocumentoPorCodigo(DOCUMENTO.getCodigo());
		assertEquals(resultado,DOCUMENTO);
	
	}
	@Test
	public void deberiaObtenerListaCodigos() {
		final List<Documento> documentos = new ArrayList();
		
		when (repositorioDocumento.obtenerListaDocumentos()).thenReturn(documentos);
		
		final List<Documento> resultado = this.ServicioDocumento.obtenerListaDocumentos();
		
		assertSame(resultado, documentos);
		
	}
}

