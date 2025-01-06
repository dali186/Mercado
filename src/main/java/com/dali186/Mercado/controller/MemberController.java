package com.dali186.Mercado.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dali186.Mercado.dto.MemberJoinDto;
import com.dali186.Mercado.entity.Member;
import com.dali186.Mercado.service.MemberService;
import com.dali186.Mercado.util.response.ResultCode;
import com.dali186.Mercado.util.response.ResultEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;

	@RequestMapping("/join")
	public ResultEntity<Member> joinMember(@RequestBody MemberJoinDto request) {
		
		return ResultEntity.success(memberService.joinMember(request), ResultCode.memberJoinSuc);
	}
}
