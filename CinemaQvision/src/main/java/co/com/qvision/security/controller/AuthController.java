package co.com.qvision.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.qvision.security.dto.JwtDto;
import co.com.qvision.security.dto.LoginUsuario;
import co.com.qvision.security.dto.NuevoUsuario;
import co.com.qvision.security.jwt.JwtProvider;
import co.com.qvision.security.models.Usuario;
import co.com.qvision.security.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {

		try {

			if (bindingResult.hasErrors())
				return new ResponseEntity<String>("bad fields or email incorrect", HttpStatus.BAD_REQUEST);
			if (usuarioService.existsByCorreo(nuevoUsuario.getCorreo()))
				return new ResponseEntity<String>("email already exists", HttpStatus.BAD_REQUEST);

			Usuario usuario = usuarioService.createNewUser(nuevoUsuario);
			usuarioService.save(usuario);			

			return new ResponseEntity<String>("user saved", HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<String>("Hubo un error al ejecutar", HttpStatus.NOT_ACCEPTABLE);

		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return new ResponseEntity<String>("bad fields", HttpStatus.BAD_REQUEST);

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getCorreo(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

		return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);

	}

}
