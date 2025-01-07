package com.dali186.Mercado.dto;

import com.dali186.Mercado.entity.Member;
import com.dali186.Mercado.entity.Post;

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
public class PostResponseDto {
	private Long postSn;
	private String title;
	private String content;
	private Long authorSn;
}
