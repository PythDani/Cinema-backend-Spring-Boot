package co.com.qvision.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.qvision.security.dto.JwtDto;
import co.com.qvision.security.dto.LoginUsuario;
import co.com.qvision.security.dto.NuevoUsuario;
import co.com.qvision.security.enums.RolNombre;
import co.com.qvision.security.jwt.JwtProvider;
import co.com.qvision.security.models.Rol;
import co.com.qvision.security.models.Usuario;
import co.com.qvision.security.service.RolService;
import co.com.qvision.security.service.TipoDocumentoService;
import co.com.qvision.security.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;
    
    @Autowired
    TipoDocumentoService tipoDocumentoService;
    
   

    @Autowired
    JwtProvider jwtProvider;
    
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    	
    	
    	 if(bindingResult.hasErrors())
             return new ResponseEntity<String>("bad fields or email incorrect", HttpStatus.BAD_REQUEST);
         if(usuarioService.existsByCorreo(nuevoUsuario.getCorreo()))
             return new ResponseEntity<String>("email already exists", HttpStatus.BAD_REQUEST);
             
         Usuario usuario = new Usuario(nuevoUsuario.getDocumento(),
					        		 nuevoUsuario.getNombres(),
					        		 nuevoUsuario.getApellidos(),
					        		 nuevoUsuario.getCorreo(),
					        		 passwordEncoder.encode(nuevoUsuario.getPassword()),
					        		 passwordEncoder.encode(nuevoUsuario.getConfirmPassword()),
					        		 nuevoUsuario.getTipoDocumentoNombre());
 
         Set<Rol> roles = new HashSet<>();
         roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER));
         
         if(nuevoUsuario.getRoles().contains("admin"))
             roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN));
         
         usuario.setRoles(roles);

         usuarioService.save(usuario);
         
         return new ResponseEntity<String>("user saved", HttpStatus.CREATED);
         
    	}
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<String>("bad fields", HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getCorreo(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
    }
         
    
         
    }
         
         
             
             
             
    
    
    


