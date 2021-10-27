package com.marioparrillamaroto.serverEventos.services;

import java.util.HashSet;
import java.util.Set;

import com.marioparrillamaroto.serverEventos.entity.Usuario;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("DetallesUsuarioService")
public class DetallesUsuarioService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String role = "USER";
        Usuario user = userRepository.findByUsername(username);
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        if (user.getCmsAdmin()) role = "ADMIN";
        else role = "USER";

        authorities.add(new SimpleGrantedAuthority(role));

        return new User(username, user.getPassword(), authorities);
    }
    
}
