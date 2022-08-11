package co.com.qvision.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.qvision.security.enums.RolNombre;
import co.com.qvision.security.models.Rol;
import co.com.qvision.security.repository.RolRepository;


@Service
@Transactional
public class RolService {
	
	
	@Autowired
	 RolRepository rolRepository;
	 
	 
	 public Rol getByRolNombre(RolNombre rolNombre){
	        return rolRepository.findByRolNombre(rolNombre);
	    }
	 
	 
	 public void save(Rol rol){
	        rolRepository.save(rol);
	    }
	 
	 


}
