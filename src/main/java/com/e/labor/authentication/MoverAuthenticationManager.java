/*
 * MoverAuthenticationManager
 */
package com.e.labor.authentication;

import com.e.labor.model.Mover;
import com.e.labor.model.Role;
import com.e.labor.service.MoverService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author jasonpalmer
 */
@Component("authManager")
public class MoverAuthenticationManager implements AuthenticationManager {
    
    private final static Logger LOG = LoggerFactory.getLogger(MoverAuthenticationManager.class.getName());
    
    @Autowired
    private MoverService moverService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String username = authentication.getPrincipal() != null ? 
                authentication.getPrincipal().toString() : 
                null;
        
        String password = authentication.getCredentials() != null ? 
                authentication.getCredentials().toString() : 
                null;

        Mover user = moverService.get(username);
        
        if (user == null) {
            LOG.info("Username returned no Mover! Authentication faiilure");
            throw new BadCredentialsException("1000");
        }
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            LOG.info("Username returned a Mover, but the password passed does not match! Authentication faiilure");
            throw new BadCredentialsException("1000");
        } 
        
        List<SimpleGrantedAuthority> userRights = new ArrayList<>();
        
        List<String> moverRights = user.getRoles();
        
        Iterator<String>it = moverRights.iterator();
        
        while(it.hasNext()){
            String role = it.next();
            userRights.add(new SimpleGrantedAuthority(role));
        }
        
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                username, 
                password, 
                userRights
        );
        
        return token;
    }

}
