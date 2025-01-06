package com.dali186.Mercado.service;

import org.springframework.stereotype.Service;

import com.dali186.Mercado.dto.MemberJoinDto;
import com.dali186.Mercado.entity.Member;
import com.dali186.Mercado.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Transactional
	public Member joinMember(MemberJoinDto request) {
		
		return memberRepository.save(request.toEntity());
	}
}
