package org.sid.jwtspringsecurity.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sid.jwtspringsecurity.entities.AppUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
     private AuthenticationManager authenticationManager;



    @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException{
        AppUser appUser=null;
        try {
            appUser = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
                System.out.println("******************");
                System.out.println("username :" + appUser.getUsername());
              System.out.println("pass :" + appUser.getPassword());
                return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(),appUser.getPassword()));
        }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
            throws IOException, ServletException {
        super.successfulAuthentication(request,response,chain,authentication);
    }

}
