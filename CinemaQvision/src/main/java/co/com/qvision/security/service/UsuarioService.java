package co.com.qvision.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.qvision.security.dto.NuevoUsuario;
import co.com.qvision.security.enums.RolNombre;
import co.com.qvision.security.models.Rol;
import co.com.qvision.security.models.Usuario;
import co.com.qvision.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	RolService rolService;

	@Autowired
	PasswordEncoder passwordEncoder;

	public Usuario createNewUser(NuevoUsuario nuevoUsuario) {

		Usuario usuario = new Usuario(nuevoUsuario.getDocumento(), nuevoUsuario.getNombres(),
				nuevoUsuario.getApellidos(), nuevoUsuario.getCorreo(),
				passwordEncoder.encode(nuevoUsuario.getPassword()),
				passwordEncoder.encode(nuevoUsuario.getConfirmPassword()), nuevoUsuario.getTipoDocumentoNombre());

		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER));

		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN));

		usuario.setRoles(roles);

		return usuario;

	}

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
