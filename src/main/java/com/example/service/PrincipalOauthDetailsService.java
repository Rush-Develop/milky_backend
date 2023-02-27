package com.example.service;

import com.example.dto.MemberTO;
import com.example.dto.auth.DiscordUserInfo;
import com.example.dto.auth.OAuth2UserInfo;
import com.example.dto.auth.PrincipalDetails;
import com.example.repository.MemberMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;

import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauthDetailsService extends DefaultOAuth2UserService {

    @Autowired
    private MemberMapperInter memberMapperInter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        System.out.println(userRequest.getClientRegistration());
        System.out.println(userRequest.getAccessToken().getTokenValue());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println(oAuth2User.getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null;
        oAuth2UserInfo = new DiscordUserInfo(oAuth2User.getAttributes());

        String id = oAuth2User.getAttribute("id");
        String name = oAuth2User.getAttribute("username");
        String email = oAuth2User.getAttribute("email");
        String password = passwordEncoder.encode("은하수!!");
        String role = "ROLE_USER";
        int point = 0;

        System.out.println("아이디 : " + id);
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);

        MemberTO to = memberMapperInter.checkMemberInfoOauth(id);

        if (to == null) {
           to = new MemberTO(id, name, null, null, email, password, null, role, point, null);
            memberMapperInter.saveMember(to);
        }

        return new PrincipalDetails(to, oAuth2UserInfo);
    }
}
