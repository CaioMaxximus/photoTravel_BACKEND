package com.PhotoTravel.photoTravel.configurations;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.PhotoTravel.photoTravel.model.User;
import com.PhotoTravel.photoTravel.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;


@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	JWTUtil jwtUtil;
	@Autowired
	UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nickname = null;
		String token = null;

		String tokenR = request.getHeader("Authorization");
		
		System.out.println("Executou o filtro");
		System.out.println(tokenR);

		// JWT Token está no form "Bearer token". Remova a palavra Bearer e pegue
		// somente o Token
		if (tokenR != null && tokenR.startsWith("Bearer ")) {
			token = tokenR.split(" ")[1].trim();
			System.out.println(token);
			try {
				nickname = jwtUtil.getUsernameFromToken(token);
				System.out.println(nickname);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.error("JWT Token does not begin with Bearer String");
		}

		if (nickname != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			User user = this.userService.getUserByNick(nickname);

			if (jwtUtil.validateToken(token, user)) {
				logger.warn("validou o token " + token);
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						user,null , new ArrayList<>());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);

	}

}
