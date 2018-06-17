package com.akashsol.snomed.searchapi.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.akashsol.snomed.searchapi.model.Description;
import com.akashsol.snomed.searchapi.repo.DescriptionRepo;
import com.akashsol.snomed.searchapi.util.ResponseModel;
import com.akashsol.snomed.searchapi.util.SearchResultModel;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class DescriptionSearchService {

	@Autowired
	private	DescriptionRepo  descriptionRepo;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	

	public ResponseModel getDescriptions(String term, Long typeId) {
	
		 BoolQueryBuilder bqb=new BoolQueryBuilder();
		
		term=term.trim().replaceAll(" +", " ");
		for (String sterm : term.split(" ")) {
	
			bqb.must(QueryBuilders.queryStringQuery(sterm.trim()+"*").field("term").analyzeWildcard(true)
			.defaultOperator(org.elasticsearch.index.query.QueryStringQueryBuilder.Operator.AND));
		}
		
			NativeSearchQueryBuilder qBuild =new NativeSearchQueryBuilder()
									.withQuery(bqb);
			
							if(typeId!=null && typeId!=0)		
								qBuild.withFilter(QueryBuilders.termQuery("typeId", typeId));
						
			SearchQuery query=qBuild.build();
					
			return elasticsearchTemplate.query(query, new ResultsExtractor<ResponseModel>() {

			    @Override
			    public ResponseModel extract(SearchResponse response) {
			    	
			    		ResponseModel searchResult = new ResponseModel();
			        long totalHits = response.getHits().totalHits();
			        searchResult.setCount(totalHits);
			        List<SearchResultModel> compResponses = new LinkedList<SearchResultModel>();
			        for (SearchHit hit : response.getHits()) {
			            if (hit != null) {
			            	
			            	ObjectMapper mapper = new ObjectMapper();
			            	Description desc = mapper.convertValue(hit.getSource(), Description.class);
			            	
			            	SearchResultModel compResponse = new SearchResultModel();
			            	compResponse.setDescription(desc);
			            	compResponse.setScore(hit.getScore());
			            	
			            	compResponses.add(compResponse);
			            }
			        }
			        searchResult.setListCompResponse(compResponses);;
			        return searchResult;
			    }
			});
			  
	}
	
	@PostConstruct
	public  void loadData() throws ParseException {
		
		elasticsearchTemplate.deleteIndex("snomedct");
		
		descriptionRepo.save(new Description((Long)2075011L,"20020131", 1, (Long)900000000000207008L, (Long)602001L, "en", (Long)900000000000013009L, "Ross river fever", (Long)900000000000017005L));
		descriptionRepo.save(new Description((Long)3572010L, "20020131", 1, (Long)900000000000207008L, (Long)1475003L, "en", (Long)900000000000013009L, "Fever blister", (Long)900000000000020002L));
		descriptionRepo.save(new Description((Long)44007011L, "20020131", 1, (Long)900000000000207008L, (Long)26275000L, "en", (Long)900000000000013009L, "Fever due to Leptospira autumnalis", (Long)900000000000020002L));
		
		
		descriptionRepo.save(new Description((Long)514391014L, "20020131", 1, (Long)900000000000207008L, (Long)135882008L, "en", (Long)900000000000003001L, "Feverish cold (finding)", (Long)900000000000020002L));	
		descriptionRepo.save(new Description((Long)514392019L, "20020131", 1, (Long)900000000000207008L, (Long)135883003L, "en", (Long)900000000000003001L, "Cough with fever (finding)", (Long)900000000000020002L));
	
	};
	
}
