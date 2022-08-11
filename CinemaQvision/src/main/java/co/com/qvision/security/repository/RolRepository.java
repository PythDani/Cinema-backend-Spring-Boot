<<<<<<< HEAD
package co.com.qvision.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.qvision.security.enums.RolNombre;
import co.com.qvision.security.models.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	Rol findByRolNombre(RolNombre rolNombre);

}
=======
package co.com.qvision.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.qvision.security.enums.RolNombre;
import co.com.qvision.security.models.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	Rol findByRolNombre(RolNombre rolNombre);

}
>>>>>>> c279d74573521fb1c19c0445369c524062666945
