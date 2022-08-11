<<<<<<< HEAD
package co.com.qvision.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.qvision.security.models.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
		
	
	Usuario findByCorreo(String correo);	
	
	boolean existsByCorreo(String correo);

}
=======
package co.com.qvision.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.qvision.security.models.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
		
	
	Usuario findByCorreo(String correo);	
	
	boolean existsByCorreo(String correo);

}
>>>>>>> c279d74573521fb1c19c0445369c524062666945
