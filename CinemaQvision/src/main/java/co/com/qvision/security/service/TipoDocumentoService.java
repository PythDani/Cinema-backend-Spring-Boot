package co.com.qvision.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.qvision.security.enums.TipoDocumentoNombre;
import co.com.qvision.security.models.TipoDocumento;
import co.com.qvision.security.repository.TipoDocumentoRepository;

@Service
@Transactional
public class TipoDocumentoService {
	
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	public TipoDocumento getByDocumentolNombre(TipoDocumentoNombre tipoDocumentoNombre){
        
		return tipoDocumentoRepository.findByTipoDocumentoNombre(tipoDocumentoNombre);
    }
	
	
	
	public void saveTipoDocumento(TipoDocumento tipoDocumento) {
		
		
		
		tipoDocumentoRepository.save(tipoDocumento);
		
	}
	

}
