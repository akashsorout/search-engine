package com.akashsol.snomed.searchapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SearchController {

	@RequestMapping("about")
	public String aboutApi() {
		return "Search API - search in SNOMED CT descriptions with term and type";
	}
	
	
	
}
