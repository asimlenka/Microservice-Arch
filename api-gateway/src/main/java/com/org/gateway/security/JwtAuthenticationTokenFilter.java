/*package com.org.gateway.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Configuration
@EnableWebSecurity
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String header = request.getHeader(this.tokenHeader);
		RequestDispatcher rd=request.getRequestDispatcher(request.getServletPath()); 
		if(null == header)
		{
			logger.info("Generating New Token.");
			rd.forward(request, response);
		}else{
			HttpEntity<String> restRequest = new HttpEntity<String>(setAuthenticationInHeader(header));
			ResponseEntity<Object> result = restTemplate.exchange("http://AUTH-SERVER/uaa/verifyToken", HttpMethod.GET, restRequest, Object.class);
			if((boolean) result.getBody()){
				logger.info("User is Authorized Successfully.");
				rd.forward(request, response);
			}else{
				logger.info("Unauthorized User.");
				throw new IllegalArgumentException("Unauthorized");
			}
		}
    }
	
	private HttpHeaders setAuthenticationInHeader(String header){
		String plainCreds = "writer:writer";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		headers.add(tokenHeader, header);
		return headers;
	}
}*/