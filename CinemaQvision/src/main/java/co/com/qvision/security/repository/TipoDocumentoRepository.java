package co.com.qvision.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import co.com.qvision.security.enums.TipoDocumentoNombre;
import co.com.qvision.security.models.TipoDocumento;


public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
	
	
	TipoDocumento findByTipoDocumentoNombre(TipoDocumentoNombre tipoDocumentoNombre);

}

