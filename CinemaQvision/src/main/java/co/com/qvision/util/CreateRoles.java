package co.com.qvision.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.com.qvision.security.enums.RolNombre;

import co.com.qvision.security.models.Rol;

import co.com.qvision.security.service.RolService;

@Component
public class CreateRoles implements CommandLineRunner {

	@Autowired
	RolService rolService;

	@Override
	public void run(String... args) throws Exception {
		Rol adminRol = new Rol(RolNombre.ROLE_ADMIN, "It is Rol of a admin");

		Rol userRol = new Rol(RolNombre.ROLE_USER, "It is Rol of a user");

		rolService.save(adminRol);
		rolService.save(userRol);

	}

}
