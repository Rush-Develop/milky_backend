package com.example.service;

import com.example.dto.MemberTO;
import com.example.dto.auth.PrincipalDetails;
import com.example.repository.MemberMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberMapperInter mapperInter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberTO to = mapperInter.checkMemberInfo(username);
        if (to != null) {
            return new PrincipalDetails(to);
        }
        return null;
    }
}
