package com.dali186.Mercado.entity;

import com.dali186.Mercado.dto.MemberDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long member_sn;
	
	@Column(length = 20, nullable = false, unique = true)
	private String id;
	
	@Column(length = 30, nullable = false)
	private String pwd;
	
	@Column(length = 10, nullable = true)
	private String name;
	
	@Column(length = 40, nullable = true)
	private String email;
	
	@Builder
	public Member(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	public Member updateMemberInfo (MemberDto member) {
		this.id = member.getId();
		this.name = member.getName();
		this.email = member.getEmail();
		
		return member.toEntity();
	}
}
