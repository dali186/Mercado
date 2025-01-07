package com.dali186.Mercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dali186.Mercado.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/common")
@RequiredArgsConstructor
public class CommonController {

	@RequestMapping("/actions")
	public String gitHubActionsTest() {
		String version = "v3";
		
		return version;
	}
}
	