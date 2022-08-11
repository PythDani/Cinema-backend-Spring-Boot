package co.com.qvision.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import co.com.qvision.security.models.UsuarioPrincipal;
import io.jsonwebtoken.*;


@Component
public class JwtProvider {
	
	/**this class generate the token,
	 * this class, has a validation method to make sure that token is ok or well formed,
	 * and is not expired.
	 */
	
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	
	/**
	 * Logger, we will used in mode devop to find the method that there is a mistake
	 */
	@Value("${jwt.secret}")
	private String secret;
	
	
	@Value("${jwt.expiration}")
	private int expiration;
	
	public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername()) //we build token
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
	
}
	
	
	public String getCorreoUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
	
	
	public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token malformed");
        }catch (UnsupportedJwtException e){
            logger.error("token Unsupported");
        }catch (ExpiredJwtException e){
            logger.error("token expiraded");
        }catch (IllegalArgumentException e){
            logger.error("token empty");
        }catch (SignatureException e){
            logger.error("fail in the signature");
        }
        return false;
    }
}
