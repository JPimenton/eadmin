package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import org.junit.Before;

public class ExpedienteTest {

	private static final Integer CODIGO_EXPEDIENTE = 1;
	private static final String NOMBRE_EXPEDIENTE = "nombre";
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ARCHIVADO = new Date();
	private static final Date FECHA_ACTUALIZACION = new Date(8/8/2003);
	private static final Boolean EXPEDIENTE_PUBLICO = true;
	private static final EstadoExpediente ESTADO_EXPEDIENTE = EstadoExpediente.INICIADO;
	private static final List<Documento> DOCUMENTOS_EXPEDIENTE = new ArrayList();
	
	private Expediente exp;
	
	@Before
	public void Inicializar() {
		exp = 
		new Expediente(CODIGO_EXPEDIENTE,NOMBRE_EXPEDIENTE,FECHA_CREACION,
				EXPEDIENTE_PUBLICO, ESTADO_EXPEDIENTE,FECHA_ACTUALIZACION,DOCUMENTOS_EXPEDIENTE);
	}
	
	@Test
	public void DOCUMENTO_PUBLICO() {
				
		assertEquals(CODIGO_EXPEDIENTE, exp.getCodigo());
		
		assertEquals(NOMBRE_EXPEDIENTE, exp.getNombre());
		
		assertEquals(FECHA_CREACION, exp.getFechaCreacion());
		
		assertEquals(EXPEDIENTE_PUBLICO, exp.getPublico());
		
		assertEquals(ESTADO_EXPEDIENTE, exp.getEstado());
		
		assertEquals(FECHA_ACTUALIZACION, exp.getFechaUltimaActualizacion());
				
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Expediente exp2 = new Expediente(CODIGO_EXPEDIENTE,NOMBRE_EXPEDIENTE,FECHA_CREACION,
				EXPEDIENTE_PUBLICO, ESTADO_EXPEDIENTE,FECHA_ACTUALIZACION,DOCUMENTOS_EXPEDIENTE);
		final Boolean resultado = exp2.equals(exp);
		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final Expediente exp2 = new Expediente(5, null, null, null, null,null,new ArrayList());

		final Boolean resultado = exp2.equals(exp);
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final boolean resultado = exp.equals(new Date());
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHashCodeDelCodigo() {
		final Expediente exp2 = new Expediente(CODIGO_EXPEDIENTE,NOMBRE_EXPEDIENTE,FECHA_CREACION,
				EXPEDIENTE_PUBLICO, ESTADO_EXPEDIENTE,FECHA_ACTUALIZACION,DOCUMENTOS_EXPEDIENTE);
		final int resultado = exp2.hashCode();
		assertEquals(exp.hashCode(), resultado);
	}

	
}