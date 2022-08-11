package co.com.qvision.security.models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import co.com.qvision.security.enums.TipoDocumentoNombre;

@Entity
@Table(name = "Tipo_Documento")
public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocumento;
	
	
	@Enumerated(EnumType.STRING)
	private TipoDocumentoNombre tipoDocumentoNombre;
	
	@OneToMany(mappedBy = "tipoDocumento", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private Set<Usuario> usuario =new HashSet<>();	
	

	public TipoDocumento() {
		super();
	}
	
	

	public TipoDocumento(int idDocumento, TipoDocumentoNombre tipoDocumentoNombre) {
		super();
		this.idDocumento = idDocumento;
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}



	public TipoDocumento(TipoDocumentoNombre tipoDocumentoNombre) {
		super();
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public TipoDocumentoNombre getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}

	public void setTipoDocumentoNombre(TipoDocumentoNombre tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}
	
	
	
	

}
