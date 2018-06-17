package com.akashsol.snomed.searchapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akashsol.snomed.searchapi.model.Description;
import com.akashsol.snomed.searchapi.service.DescriptionSearchService;
import com.akashsol.snomed.searchapi.util.ResponseModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value="Search API : search a term (description) in SNOMED CT",description="To search a term (description) in SNOMED CT")
public class SearchController {
	
	@Autowired
	DescriptionSearchService descriptionSearchService;
	

	@GetMapping("descriptions")
	@ApiOperation(value="Returns list of description with score and total count",response=ResponseModel.class)
	@ApiResponses(@ApiResponse(code = 200, message = "Returns list of description with score and total count"))
	public ResponseEntity<ResponseModel> getDescriptions( @ApiParam(required=true,value="Clinical term present in SNOMED CT : fever")  @RequestParam("term")String term, @ApiParam(value="Type of Description <br>FSN : 900000000000003001 <br>Synonym : 900000000000013009") @RequestParam(value="typeId", required=false) Long typeId)
	{
		if(null==term)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		return new ResponseEntity<>(descriptionSearchService.getDescriptions(term, typeId), HttpStatus.OK);
	}
	
	
	@PostMapping("descriptions")
	@ApiOperation(value="Returns list of description with score and total count",response=ResponseModel.class)
	@ApiResponses(@ApiResponse(code = 200, message = "Returns list of description with score and total count"))
	public ResponseEntity<ResponseModel> getDescriptions(@ApiParam(required=true ,value="term (required) present in SNOMED CT and typeId (optional) with possible values - 900000000000003001, 900000000000013009. Other data elements can be ignored or removed.") @RequestBody Description description)
	{
		if(null==description || null==description.getTerm())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(descriptionSearchService.getDescriptions(description.getTerm(), description.getTypeId()), HttpStatus.OK);
	}
	
}
