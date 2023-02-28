package com.example.milky.service;

import com.example.dto.MemberTO;
import com.example.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Service관련된 Bean 단위테스트
@SpringBootTest
public class MemberServiceUnitTest {
	@Autowired
	MemberService memberService;
	@Test
	void contextLoads() {
		MemberTO to = new MemberTO("890997392608997406", "포비", "26", null, null, null, "0", null, 0, null);

		memberService.updateMemberInfo(to);

	}

}
