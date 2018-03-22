package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.Before;

public class DocumentoTest {

	private static final Date FECHA_CREACION = new Date(1/1/2000);
	private static final Date FECHA_ACTUALIZACION = new Date(8/8/2003);
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private Documento doc;
	
	@Before
	public void Inicializar() {
		doc = 
		new Documento(CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO,FECHA_ACTUALIZACION);
	}
	
	@Test
	public void DOCUMENTO_PUBLICO() {
				
		assertEquals(CODIGO_DOCUMENTO, doc.getCodigo());
		
		assertEquals(NOMBRE_DOCUMENTO, doc.getNombre());
		
		assertEquals(FECHA_CREACION, doc.getFechaCreacion());
		
		assertEquals(FECHA_ACTUALIZACION, doc.getFechaUltimaActualizacion());
		
		assertEquals(DOCUMENTO_PUBLICO, doc.getPublico());
		
		assertEquals(EstadoDocumento.ACTIVO, doc.getEstado());
				
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Documento doc2 = new Documento(CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO,FECHA_ACTUALIZACION);
		final Boolean resultado = doc2.equals(doc);
		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final Documento doc2 = new Documento(5, null, null, null, null, null);

		final Boolean resultado = doc2.equals(doc);
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final boolean resultado = doc.equals(new Date());
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHashCodeDelCodigo() {
		final int resultado = doc.hashCode();
		assertEquals(CODIGO_DOCUMENTO.hashCode(), resultado);
	}

	@Test
	public void testeoToString() {
		assertNotNull(doc.toString());
	}
	
}
