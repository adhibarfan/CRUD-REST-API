/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.service;

import com.arfan.adhib.domain.UserRole;
import com.arfan.adhib.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author emerio
 */
@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.arfan.adhib.domain.User user = userRepository.loginUser(username);

        if (user != null) {
            List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());
            return buildUserForAuthentication(user, authorities);
        }

        return null;
    }

    private User buildUserForAuthentication(com.arfan.adhib.domain.User user, List<GrantedAuthority> grantedAuthorities) {
        return new User(user.getUsername(), user.getPassword(), user.getEnable(), true, true, true, grantedAuthorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        userRoles.stream().forEach((userRole) -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        });

        return new ArrayList<>(grantedAuthorities);
    }

}