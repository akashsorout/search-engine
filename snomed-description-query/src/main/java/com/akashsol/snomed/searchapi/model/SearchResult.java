package com.akashsol.snomed.searchapi.model;

import java.util.List;

public class SearchResult {
	
	List<CompResponse> listCompResponse;
	long count;
	
	
	public List<CompResponse> getListCompResponse() {
		return listCompResponse;
	}
	public void setListCompResponse(List<CompResponse> listCompResponse) {
		this.listCompResponse = listCompResponse;
	}

	public void addCompResponse(CompResponse compResponse) {
		this.listCompResponse.add(compResponse);
	}
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}

}
