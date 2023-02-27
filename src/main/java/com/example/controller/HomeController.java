package com.example.controller;

import com.example.dto.MemberTO;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/")
    public String printHello () {
        return "redirect:/index";
    }

    @RequestMapping("/loginview")
    public String loginPageView () {
        return "loginpage";
    }

    @RequestMapping("/join")
    public String join (MemberTO to, Model model) {
        int flag = memberService.saveMember(to);
        model.addAttribute("flag",flag);
        return "redirect:/loginview";
    }


}
