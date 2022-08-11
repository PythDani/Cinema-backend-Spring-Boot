package co.com.qvision.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import co.com.qvision.security.service.UserDetailServiceImpl;

public class JwtTokenFilter extends OncePerRequestFilter{
	
	/** this class, will be execute once time for each request.
	 * Through of the class Jwtprovider, will check the token validity,
	 * In case that token is valid, will allow the access to resource,
	 * Else, will raise exception.
	 * 
	 * 
	 */
	 @Autowired
	  JwtProvider jwtProvider;
	 
	 @Autowired
	 UserDetailServiceImpl userDetailsService;
	
	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		 try {
	            String token = getToken(req);
	            if(token != null && jwtProvider.validateToken(token)){
	                String correoUsuario = jwtProvider.getCorreoUsuarioFromToken(token);
	                UserDetails userDetails = userDetailsService.loadUserByUsername(correoUsuario);

	                UsernamePasswordAuthenticationToken auth =
	                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                SecurityContextHolder.getContext().setAuthentication(auth);
	            }
	        } catch (Exception e){
	            logger.error("fail en el método doFilter " + e.getMessage());
	        }
	        filterChain.doFilter(req, res);
		
	}
	
	
	
	 private String getToken(HttpServletRequest request){
	        String header = request.getHeader("Authorization");
	        if(header != null && header.startsWith("Bearer"))
	            return header.replace("Bearer ", "");
	        return null;
	    }
	
	
	
	

}
