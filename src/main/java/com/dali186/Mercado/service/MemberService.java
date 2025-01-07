package com.dali186.Mercado.service;

import java.util.List;
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
	 * domain: Service
	 * ========================================
	 * @since 2025. 1. 6.
	 * @author JOOWON
	 */
	@Transactional
	public Member joinMember(MemberDto request) {
		
		return memberRepository.save(request.toEntity());
	}
	
	/**
	 * methodName: findMember
	 * description: 단일 사용자 조회
	 * domain: Service
	 * ========================================
	 * @since 2025. 1. 7.
	 * @author jwkim
	 */
	@Transactional
	public Member findMember(Long memberSn) {
		
		return memberRepository.findById(memberSn).orElseThrow(() -> new ResourceNotFoundException(ResultCode.memberFindErr, 404));
	}
	
	/**
	 * methodName: findMemberList
	 * description: 전체사용자 조회
	 * domain: Service
	 * ========================================
	 * @since 2025. 1. 7.
	 * @author jwkim
	 */
	@Transactional
	public List<Member> findMemberList() {
		
		return memberRepository.findAll();
	}
	
	/**
	 * methodName: updateMember
	 * description: 사용자 업데이트
	 * domain: Service
	 * ========================================
	 * @since 2025. 1. 7.
	 * @author jwkim
	 */
	@Transactional
	public Member updateMember(MemberDto request) {
		Long memberSn = request.getMemberSn();
		Member member = findMember(memberSn);
		
		return member.updateMemberInfo(request);
	}
}
