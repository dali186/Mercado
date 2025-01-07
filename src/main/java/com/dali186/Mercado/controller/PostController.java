package com.dali186.Mercado.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dali186.Mercado.dto.PostRequestDto;
import com.dali186.Mercado.dto.PostResponseDto;
import com.dali186.Mercado.entity.Member;
import com.dali186.Mercado.entity.Post;
import com.dali186.Mercado.service.PostService;
import com.dali186.Mercado.util.response.ResultCode;
import com.dali186.Mercado.util.response.ResultEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
	
	private final PostService postService;
	
	@RequestMapping("/register")
	public ResultEntity<PostResponseDto> registerPost(@RequestBody PostRequestDto request) {
		Long memberSn = 3L;
		
		Post savedPost = postService.registerPost(request, memberSn);
		return ResultEntity.success(postService.convertToResponseDto(savedPost), ResultCode.POST_REGI_SUCC);
	}
	
	@RequestMapping("/findPost/{postSn}")
	public ResultEntity<PostResponseDto> findPost(@PathVariable("postSn") Long postSn) {
		Post foundPost = postService.findPost(postSn);
		
		return ResultEntity.success(postService.convertToResponseDto(foundPost), ResultCode.COMMON_FIND_SUCC);
	}

	@RequestMapping("/findPost/all")
	public ResultEntity<List<PostResponseDto>> findPostList() {
		List<Post> postList = postService.findPostList();
		
		return ResultEntity.success(postList.stream().map(postService::convertToResponseDto).collect(Collectors.toList()),
				ResultCode.COMMON_FIND_SUCC);
	}
	
	@RequestMapping("/updatePost")
	public ResultEntity<PostResponseDto> updatePost(@RequestBody PostRequestDto request) {
		Post updatedPost = postService.updatePost(request);
		
		return ResultEntity.success(postService.convertToResponseDto(updatedPost), ResultCode.POST_UPD_SUCC);
	}
	
	@RequestMapping("/deletePost/{postSn}")
	public ResultEntity<Member> deletePost(@PathVariable("postSn") Long postSn) {
		postService.deletePost(postSn);
		return ResultEntity.success(null, ResultCode.POST_DEL_SUCC);
	}
}
