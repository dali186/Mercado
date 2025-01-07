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
public class PostRequestDto {
	private Long postSn;
	private String title;
	private String content;
	private Member author;
	
	public Post toEntity() {
		return Post.builder()
				.title(this.title)
				.content(this.content)
				.author(this.author)
				.build();
	}
}
