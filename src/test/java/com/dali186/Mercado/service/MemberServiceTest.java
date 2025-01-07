package com.dali186.Mercado.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dali186.Mercado.dto.MemberDto;
import com.dali186.Mercado.entity.Member;
import com.dali186.Mercado.repository.MemberRepository;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
	
	@Mock
	private MemberRepository memberRepository;
	
	@InjectMocks
	private MemberService memberService;
	
	@Test
	@DisplayName("사용자 가입 테스트")
	public void joinMemberTest() {
		//given
		MemberDto memberDto = MemberDto.builder().id("tester01").pwd("tester12!@").name("tester").email("tester01@test.com").build();
		Member member = new Member(1L, "tester01", "tester12!@", "tester", "tester01@test.com");
		given(memberRepository.save(any(Member.class))).willReturn(member);
		//when
		Member joinedMember = memberService.joinMember(memberDto);
		//then
		Assertions.assertThat(joinedMember).isEqualTo(member);
	}
	
	@Test
	@DisplayName("사용자 정보 업데이트 테스트")
	public void updateMemberTest() {
		//given
		MemberDto updateMemberDto = MemberDto.builder().id("tester02").pwd("tester34!@").name("tester02").email("tester02@test.com").build();
		Member member = new Member(1L, "tester01", "tester12!@", "tester", "tester01@test.com");
		given(memberService.findMember(member.getMember_sn())).willReturn(member);
		//when
		when(memberRepository.save(null)).thenReturn(member);
		Member updatedMember = memberService.updateMember(updateMemberDto);
		//then
		Assertions.assertThat(updatedMember.getMember_sn()).isEqualTo(member.getPwd());
		Assertions.assertThat(updatedMember.getId()).isEqualTo(updateMemberDto.getId());
		Assertions.assertThat(updatedMember.getPwd()).isEqualTo(member.getPwd());
		Assertions.assertThat(updatedMember.getName()).isEqualTo(updateMemberDto.getName());
		Assertions.assertThat(updatedMember.getEmail()).isEqualTo(updateMemberDto.getEmail());
	}

}
