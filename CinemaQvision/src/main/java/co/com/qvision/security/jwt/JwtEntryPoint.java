package co.com.qvision.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

	/**
	 * This class check if there is a Valid Token,
	 * Else, return a response 401 not authorized */

	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
	
	/**
	 * Logger, we will used in devop to find the method that there is a mistake
	 */

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e)
			throws IOException, ServletException {
		logger.error("fail en el método commence");
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");

	}

}
