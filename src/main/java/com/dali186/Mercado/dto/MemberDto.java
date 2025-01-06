package com.dali186.Mercado.dto;

import com.dali186.Mercado.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	public Member toEntity() {
		return Member.builder()
				.id(this.id)
				.pwd(this.pwd)
				.name(this.name)
				.email(this.email)
				.build();
	}
}
