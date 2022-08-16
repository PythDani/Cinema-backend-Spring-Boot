package co.com.qvision.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.com.qvision.security.enums.TipoDocumentoNombre;
import co.com.qvision.security.models.TipoDocumento;
import co.com.qvision.security.service.TipoDocumentoService;


@Component
public class CreateTipoDocumento implements CommandLineRunner{
	
	@Autowired
	TipoDocumentoService tipoDocumentoService;


	@Override
	public void run(String... args) throws Exception {
		
		TipoDocumento tipoDocumento1 = new TipoDocumento(TipoDocumentoNombre.CC);
		TipoDocumento tipoDocumento2 = new TipoDocumento(TipoDocumentoNombre.CE);
		TipoDocumento tipoDocumento3 = new TipoDocumento(TipoDocumentoNombre.DNI);
		TipoDocumento tipoDocumento4 = new TipoDocumento(TipoDocumentoNombre.PAS);
		
		tipoDocumentoService.saveTipoDocumento(tipoDocumento1);
		tipoDocumentoService.saveTipoDocumento(tipoDocumento2);
		tipoDocumentoService.saveTipoDocumento(tipoDocumento3);
		tipoDocumentoService.saveTipoDocumento(tipoDocumento4);

		
	}

}
