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
import lombok.extern.log4j.Log4j2;

@Log4j2
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
		
		log.info(request.getId() + "joined.");
		return ResultEntity.success(memberService.joinMember(request), request.getId() + ResultCode.MEMBER_JOIN_SUCC);
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
	public ResultEntity<Member> findMember(@PathVariable("memberSn") Long memberSn) {
		Member member = memberService.findMember(memberSn);
		return ResultEntity.success(member, member.getId() + ResultCode.MEMBER_FIND_SUCC);
	}
	
	/**
	 * methodName:findMeberList
	 * description: 전체 사용자 조회
	 * domain: controller
	 * ========================================
	 * @since 2025. 1. 7.
	 * @author jwkim
	 */
	@RequestMapping("/findMember/all")
	public ResultEntity<List<Member>> findMemberList() {
		
		return ResultEntity.success(memberService.findMemberList(), ResultCode.COMMON_FIND_SUCC);
	}
	
	/**
	 * methodName: updateMember
	 * description: 사용자 업데이트
	 * domain: controller
	 * ========================================
	 * @since 2025. 1. 7.
	 * @author jwkim
	 */
	@RequestMapping("/updateMember")
	public ResultEntity<Member> updateMember(MemberDto request) {
		Member updatedMember = memberService.updateMember(request);
		return ResultEntity.success(updatedMember, updatedMember.getId() + ResultCode.MEMBER_UPD_SUCC);
	}
	
	/**
	 * methodName: deleteMember
	 * description: 사용자 제거
	 * domain: controller
	 * ========================================
	 * @since 2025. 1. 7.
	 * @author jwkim
	 */
	@RequestMapping("/deleteMember")
	public ResultEntity<Member> deleteMember(Long memberSn) {
		memberService.deleteMember(memberSn);
		return ResultEntity.success(null, ResultCode.MEMBER_DEL_SUCC);
	}
}
