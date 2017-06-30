package com.org.auth.controller;

import java.security.InvalidKeyException;
import java.security.SignatureException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.auth.domain.UserDetails;
import com.org.auth.service.security.JwtTokenUtil;
import com.org.auth.service.security.MongoUserDetailsService;

import io.jsonwebtoken.Claims;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private MongoUserDetailsService userDetailsService;
    
    @Value("${jwt.header}")
    private String tokenHeader;

	@RequestMapping(value = "/generateToken", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody String createJsonWebToken(@RequestBody UserDetails user) throws SignatureException {
		UserDetails userDetails = this.userDetailsService.loadUserByUser(user.getUsername());
		if(userDetails!=null && userDetails.getUsername().equals(user.getUsername()) 
				&& userDetails.isAccountNonExpired() && userDetails.isAccountNonLocked()){
		return jwtTokenUtil.generateToken(user.getUsername());
		}
		return null;
	}

	@RequestMapping(value = "/verifyToken", method = RequestMethod.POST, consumes="text/plain")
	public @ResponseBody Boolean validateToken(@RequestBody String token) throws InvalidKeyException {
		return jwtTokenUtil.validateToken(token);
	}
	
	@RequestMapping(value = "/refreshToken", method = RequestMethod.POST, consumes="text/plain")
	public @ResponseBody String refreshToken(@RequestBody String token) throws Exception {
		return jwtTokenUtil.refreshToken(token);
	}
	
	@RequestMapping(value = "/returnTokenClaims", method = RequestMethod.POST, produces="application/json", consumes="text/plain")
	public @ResponseBody Claims returnTokenClaims(@RequestBody String token) throws InvalidKeyException {
		return jwtTokenUtil.getClaimsFromToken(token);
	}
/*	
	private String extractTokenFromRequestHeader(HttpServletRequest request){
		String header = request.getHeader(this.tokenHeader);
		return header;
	}*/
}
