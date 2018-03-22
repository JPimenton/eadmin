package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.Before;

public class TestBase {
	public class AdministracionElectronicaBaseFake extends AdministracionElectronicaBase {

		public AdministracionElectronicaBaseFake(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, Date fechaActualizacion) {
			super(codigo, nombre, fechaCreacion, publico, fechaActualizacion);
		}
		
	}

	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ACTUALIZACION = new Date(8/8/2003);
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private AdministracionElectronicaBaseFake base;
	
	@Before
	public void Inicializar() {
		base = 
		new AdministracionElectronicaBaseFake(CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				DOCUMENTO_PUBLICO, FECHA_ACTUALIZACION);
	}
	
	@Test
	public void DOCUMENTO_PUBLICO() {
				
		assertEquals(CODIGO_DOCUMENTO, base.getCodigo());
		
		assertEquals(NOMBRE_DOCUMENTO, base.getNombre());
		
		assertEquals(FECHA_CREACION, base.getFechaCreacion());
		
		assertEquals(DOCUMENTO_PUBLICO, base.getPublico());
				
		assertEquals(FECHA_ACTUALIZACION, base.getFechaUltimaActualizacion());

	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final AdministracionElectronicaBaseFake base2 = new AdministracionElectronicaBaseFake(CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				DOCUMENTO_PUBLICO,FECHA_ACTUALIZACION);
		final Boolean resultado = base2.equals(base);
		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final AdministracionElectronicaBaseFake base2 = new AdministracionElectronicaBaseFake(5, null, null, null,null);

		final Boolean resultado = base2.equals(base);
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final boolean resultado = base.equals(new Date());
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHashCodeDelCodigo() {
		final int resultado = base.hashCode();
		assertEquals(CODIGO_DOCUMENTO.hashCode(), resultado);
	}

	@Test
	public void testeoToString() {
		assertNotNull(base.toString());
	}
	
}