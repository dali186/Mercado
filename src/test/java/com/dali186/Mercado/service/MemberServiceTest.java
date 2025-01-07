package com.dali186.Mercado.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dali186.Mercado.dto.MemberDto;
import com.dali186.Mercado.entity.Member;
import com.dali186.Mercado.repository.MemberRepository;
import com.dali186.Mercado.util.exception.ResourceDuplicatedException;
import com.dali186.Mercado.util.exception.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
	
	   @Mock
	    private MemberRepository memberRepository;

	    private MemberService memberService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        memberService = new MemberService(memberRepository);
	    }

	    @Test
	    void testJoinMember() throws ResourceDuplicatedException {
	        MemberDto memberDto = new MemberDto(1L, "tester", "password", "Tester", "tester@test.com");
	        Member member = memberDto.toEntity();

	        // When: 회원가입
	        when(memberRepository.save(any(Member.class))).thenReturn(member);

	        Member result = memberService.joinMember(memberDto);

	        // Then: 저장된 회원 객체가 반환되어야 함
	        assertNotNull(result);
	        assertEquals("tester", result.getId());
	        verify(memberRepository, times(1)).save(any(Member.class));
	    }

	    @Test
	    void testFindMember() {
	        Long memberSn = 1L;
	        Member member = new Member(1L, "tester", "password", "Tester", "tester@test.com");

	        // When: 회원 조회
	        when(memberRepository.findById(eq(memberSn))).thenReturn(Optional.of(member));

	        Member result = memberService.findMember(memberSn);

	        // Then: 해당 회원이 반환되어야 함
	        assertNotNull(result);
	        assertEquals(memberSn, result.getMemberSn());
	        assertEquals("tester", result.getId());
	        verify(memberRepository, times(1)).findById(eq(memberSn));
	    }

	    @Test
	    void testFindMember_throwsException_whenNotFound() {
	        Long memberSn = 1L;

	        // When: 회원 조회 (회원이 존재하지 않으면 예외 발생)
	        when(memberRepository.findById(eq(memberSn))).thenReturn(Optional.empty());

	        // Then: ResourceNotFoundException 예외가 발생해야 함
	        assertThrows(ResourceNotFoundException.class, () -> memberService.findMember(memberSn));
	    }

	    @Test
	    void testFindMemberList() {
	        // Given: 회원 목록
	        Member member1 = new Member(1L, "tester1", "password", "Tester1", "tester1@test.com");
	        Member member2 = new Member(2L, "tester2", "password", "Tester2", "tester2@test.com");

	        // When: 회원 목록 조회
	        when(memberRepository.findAll()).thenReturn(Arrays.asList(member1, member2));

	        // Then: 회원 목록이 반환되어야 함
	        var result = memberService.findMemberList();
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        verify(memberRepository, times(1)).findAll();
	    }

	    @Test
	    void testUpdateMember() {
	        Long memberSn = 1L;
	        MemberDto memberDto = new MemberDto(1L, "tester", "password", "Updated Name", "updated@test.com");
	        Member member = new Member(1L, "tester", "password", "Tester", "tester@test.com");

	        // When: 회원 조회 후 업데이트
	        when(memberRepository.findById(eq(memberSn))).thenReturn(Optional.of(member));
	        when(memberRepository.save(any(Member.class))).thenReturn(member);

	        Member result = memberService.updateMember(memberDto);

	        // Then: 업데이트된 회원 객체가 반환되어야 함
	        assertNotNull(result);
	        assertEquals("Updated Name", result.getName());
	        verify(memberRepository, times(1)).findById(eq(memberSn));
	        verify(memberRepository, times(1)).save(any(Member.class));
	    }

	    @Test
	    void testDeleteMember() {
	        Long memberSn = 1L;

	        // When: 회원 삭제
	        doNothing().when(memberRepository).deleteById(eq(memberSn));

	        memberService.deleteMember(memberSn);

	        // Then: 삭제 메서드가 호출되어야 함
	        verify(memberRepository, times(1)).deleteById(eq(memberSn));
	    }

}
