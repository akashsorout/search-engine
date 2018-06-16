package com.akashsol.snomed.searchapi.controller;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akashsol.snomed.searchapi.model.Description;
import com.akashsol.snomed.searchapi.model.SearchResult;
import com.akashsol.snomed.searchapi.service.DescriptionSearchService;

@RestController
@RequestMapping("/api")
public class SearchController {
	
	@Autowired
	DescriptionSearchService descriptionSearchService;
	

	@RequestMapping("about")
	public String aboutApi() {
		return "Search API - search in SNOMED CT descriptions with term and type";
	}
	

	
	@GetMapping("descriptionstemp")
	public Iterable<Description>  getDescriptions(@QueryParam("term")String term, @QueryParam("typeId") Long typeId)
	{
		return descriptionSearchService.getDescriptionsTemp(term, typeId);
	}
	
	@GetMapping("descriptions")
	
	public ResponseEntity<SearchResult> getDescriptionstemp(@QueryParam("term")String term, @QueryParam("typeId") Long typeId)
	{
		if(null==term)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		return new ResponseEntity<SearchResult>(descriptionSearchService.getDescriptions(term, typeId), HttpStatus.OK);
	}
	
}
