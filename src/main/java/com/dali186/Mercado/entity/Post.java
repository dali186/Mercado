package com.dali186.Mercado.entity;

import com.dali186.Mercado.dto.PostRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Post extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postSn;
	@Column(length = 100, nullable = false)
	private String title;
	@Column(nullable = false)
	private String content;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_sn", referencedColumnName = "memberSn")
	private Member author;
	
	@Builder
	public Post(String title, String content, Member author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Post updatePost(PostRequestDto post) {
		this.title = post.getTitle();
		this.content = post.getContent();
		
		return post.toEntity();
	}
}
