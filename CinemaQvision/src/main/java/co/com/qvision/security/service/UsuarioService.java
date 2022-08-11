<<<<<<< HEAD
package co.com.qvision.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.qvision.security.models.Usuario;
import co.com.qvision.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	
	
	public Usuario getByCorreoUsuario(String correo) {
		return usuarioRepository.findByCorreo(correo);
	}

	

	public boolean existsByCorreo(String correo) {
		return usuarioRepository.existsByCorreo(correo);
	}

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

}
=======
package co.com.qvision.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.qvision.security.models.Usuario;
import co.com.qvision.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	
	
	public Usuario getByCorreoUsuario(String correo) {
		return usuarioRepository.findByCorreo(correo);
	}

	

	public boolean existsByCorreo(String correo) {
		return usuarioRepository.existsByCorreo(correo);
	}

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

}
>>>>>>> c279d74573521fb1c19c0445369c524062666945
