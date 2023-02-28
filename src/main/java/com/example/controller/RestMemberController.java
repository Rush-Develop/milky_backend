package com.example.controller;

import com.example.dto.MemberTO;
import com.example.dto.auth.PrincipalDetails;
import com.example.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RestMemberController {

    private final MemberService memberService;

    @PostMapping("/api/join")
    public int joinApi(MemberTO to) {
        int flag = memberService.saveMember(to);
        return flag;
    } // 멤버 회원가입 로직

    @GetMapping("/api/logininfo")
    public MemberTO showOAuthLoginInfo(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return principalDetails.getTo();
    }

    @RequestMapping("/api/member/update/{id}")
    public MemberTO myinfoUpdateApi(@PathVariable("id") String id,@RequestBody MemberTO to) {
        System.out.println(to);
        memberService.updateMemberInfo(id, to);
        to = memberService.findMemberById(id);
        return to;
    }

}
