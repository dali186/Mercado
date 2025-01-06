package com.dali186.Mercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

	@RequestMapping("/actions")
	public String gitHubActionsTest() {
		String version = "v3";
		
		return version;
	}
}
