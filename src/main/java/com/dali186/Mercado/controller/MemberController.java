package com.dali186.Mercado.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dali186.Mercado.dto.MemberDto;
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

	/**
	 * methodName: joinMember
	 * description: 사용자 회원가입
	 * domain: controller
	 * ========================================
	 * @since 2025. 1. 6.
	 * @author JOOWON
	 */
	@RequestMapping("/join")
	public ResultEntity<Member> joinMember(@RequestBody MemberDto request) {
		
		return ResultEntity.success(memberService.joinMember(request), ResultCode.memberJoinSuc);
	}
	
	/**
	 * methodName: findMember
	 * description: 단일 사용자 조회
	 * domain: controller
	 * ========================================
	 * @since 2025. 1. 7.
	 * @author jwkim
	 */
	@RequestMapping("/findMember/{memberSn}")
	public ResultEntity<Member> findMember(@PathVariable("id") Long memberSn) {
		Member member = memberService.findMember(memberSn);
		return ResultEntity.success(member, ResultCode.memberJoinSuc);
	}
	
	@RequestMapping("/findMember/all")
	public ResultEntity<List<Member>> findMemberList() {
		
		return ResultEntity.success(memberService.findMemberList(), ResultCode.memberFindSuc);
	}
}
