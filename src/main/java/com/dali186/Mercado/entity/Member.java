package com.dali186.Mercado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@ToString
public class Member extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long member_sn;
	
	@Column(length = 20, nullable = false, unique = true, name = "member_id")
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
}
