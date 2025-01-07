package com.dali186.Mercado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dali186.Mercado.repository.PostRepository;
import com.dali186.Mercado.util.exception.ResourceNotFoundException;
import com.dali186.Mercado.util.response.ResultCode;

import jakarta.transaction.Transactional;

import com.dali186.Mercado.dto.PostRequestDto;
import com.dali186.Mercado.dto.PostResponseDto;
import com.dali186.Mercado.entity.Member;
import com.dali186.Mercado.entity.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final MemberService memberService;
	private final PostRepository postRepository;
	
	public PostResponseDto convertToResponseDto(Post post) {
	    PostResponseDto response = PostResponseDto.builder()
                .postSn(post.getPostSn())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
	    if (post.getAuthor() != null) {
	    	response.setAuthorSn(post.getAuthor().getMemberSn());
	    }
	    
	    return response;
	}
		
	@Transactional
	public Post registerPost(PostRequestDto request, Long memberSn) {
		Member author = memberService.findMember(memberSn);
		request.setAuthor(author);
		
		return postRepository.save(request.toEntity());
	}
	
	@Transactional
	public Post findPost(Long postSn) {
		Post post = postRepository.findById(postSn).orElseThrow(() -> new ResourceNotFoundException(ResultCode.POST_FIND_ERR, 404));
		return post;
	}
	
	@Transactional
	public List<Post> findPostList() {
		List<Post> postList = postRepository.findAll();
		
		return postList;
	}
	
	@Transactional
	public Post updatePost(PostRequestDto request) {
		Post post = this.findPost(request.getPostSn());
		
		return post.updatePost(request);
	}
	
	@Transactional
	public void deletePost(Long postSn) {
		postRepository.deleteById(postSn);
	}
}
