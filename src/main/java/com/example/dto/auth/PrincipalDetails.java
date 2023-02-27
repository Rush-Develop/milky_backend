package com.example.dto.auth;

import com.example.dto.MemberTO;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetails implements UserDetails ,OAuth2User {

    private MemberTO to;

    private OAuth2UserInfo oAuth2UserInfo;

    private Collection<? extends GrantedAuthority> authorities;
    private Map<String,Object> attributes;

    public PrincipalDetails(MemberTO to) {
        this.to = to;
    }

    public PrincipalDetails(MemberTO to, OAuth2UserInfo oAuth2UserInfo) {
        this.to = to;
        this.oAuth2UserInfo = oAuth2UserInfo;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2UserInfo.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return to.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return to.getPassword();
    }

    @Override
    public String getUsername() {
        return to.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return oAuth2UserInfo.getName();
    }
}
