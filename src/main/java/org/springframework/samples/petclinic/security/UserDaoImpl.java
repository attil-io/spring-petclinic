package org.springframework.samples.petclinic.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDaoImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<? extends GrantedAuthority> authorities = 
                Arrays.asList(new GrantedAuthority[]{ new SimpleGrantedAuthority("ROLE_MEMBER") });
        UserDetails ud = new User(username, "password", authorities);
        return ud;
    }
}
