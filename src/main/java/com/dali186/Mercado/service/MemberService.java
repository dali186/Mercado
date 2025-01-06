package com.dali186.Mercado.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dali186.Mercado.dto.MemberDto;
import com.dali186.Mercado.entity.Member;
import com.dali186.Mercado.repository.MemberRepository;
import com.dali186.Mercado.util.exception.ResourceNotFoundException;
import com.dali186.Mercado.util.response.ResultCode;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	/**
	 * methodName: joinMember
	 * description: 사용자 회원가입
	 *
	 * ========================================
	 * @since 2025. 1. 6.
	 * @author JOOWON
	 */
	@Transactional
	public Member joinMember(MemberDto request) {
		
		return memberRepository.save(request.toEntity());
	}
	
	@Transactional
	public Member findMember(Long memberSn) {
		
		return memberRepository.findById(memberSn).orElseThrow(() -> new ResourceNotFoundException(ResultCode.memberFindErr, 404));
	}
}
