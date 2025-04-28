package com.IOE.cs.city_sync.Security.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUrl = "/";
        for(GrantedAuthority authority : authentication.getAuthorities()){
            if(authority.getAuthority().equals("ROLE_ADMIN")){
                redirectUrl = "/admin";
                break;
            }
            else {
                redirectUrl = "/user";
            }
        }
        response.sendRedirect(redirectUrl);
    }
}
