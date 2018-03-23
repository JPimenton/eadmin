package es.fpdual.eadmin.eadmin.modelo.builder;

import java.math.BigDecimal;
import java.util.Date;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class DocumentoContableBuilder extends DocumentoBuilder {

	private BigDecimal importe;
	private String nifInteresado;
	
	public DocumentoContable construir(){
		return new DocumentoContable(codigo, nombre, fechaCreacion, 
				publico,  estado, fechaUltimaActualizacion,
				 importe,  nifInteresado);
	}
	
	public DocumentoContableBuilder conImporte(BigDecimal importe) {
		this.importe=importe;
		return this;
	}

	public DocumentoContableBuilder clonar(DocumentoContable documento) {
		super.clonar(documento);
		this.importe = documento.getImporte();
		this.nifInteresado = documento.getNifInteresado();
		return this;
	}
}
