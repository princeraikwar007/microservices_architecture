package com.projectAtoZ.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConnect {

	
	@GetMapping("con")
	public String testConn() {
		return "runnign api-gateway";
	}
	
}
