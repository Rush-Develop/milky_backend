package com.example.controller;

import com.example.dto.MemberTO;
import com.example.dto.auth.PrincipalDetails;
import com.example.service.MemberService;
import com.example.service.PrincipalOauthDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RestMemberController {

    private final MemberService memberService;

    private final PrincipalOauthDetailsService principalOauthDetailsService;

    @PostMapping("/api/join")
    public int joinApi(MemberTO to) {
        int flag = memberService.saveMember(to);
        return flag;
    } // 멤버 회원가입 로직

    @GetMapping("/api/member/mypage/{id}")
    public MemberTO myinfoApi(@PathVariable("id") String id) {
        MemberTO to = memberService.findMemberById(id);
        return to;
    }

    @GetMapping("/api/logininfo")
    public MemberTO showOAuthLoginInfo(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return principalDetails.getTo();
    }

    @PostMapping("/api/member/update/{id}")
    public MemberTO myinfoUpdateApi(@PathVariable("id") String id, MemberTO to) {
        memberService.updateMemberInfo(id);
        to = memberService.findMemberById(id);
        return to;
    }

}
