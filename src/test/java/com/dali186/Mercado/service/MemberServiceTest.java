package com.dali186.Mercado.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dali186.Mercado.util.exception.ResourceNotFoundException;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void findMemberNotFoundTest() {
		Long invalidIdLong = 999L;
		
		assertThrows(ResourceNotFoundException.class, () -> {
			memberService.findMember(invalidIdLong);
		});
	}

}
