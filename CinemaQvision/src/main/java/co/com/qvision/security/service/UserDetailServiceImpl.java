package co.com.qvision.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.qvision.security.models.Usuario;
import co.com.qvision.security.models.UsuarioPrincipal;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	
	/**This class transform Usuario's class to UsuarioPrincipal
	 * UsuarioPrincipal: class that is used by springSecurity to obtain user data and user privileges
	 * 
	 * */
	 

	@Autowired
	UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String correoUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByCorreoUsuario(correoUsuario);
		return UsuarioPrincipal.build(usuario);

	}

}
