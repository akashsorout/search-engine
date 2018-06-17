package com.akashsol.snomed.searchapi.util;

import java.util.List;

public class ResponseModel {
	
	List<SearchResultModel> listCompResponse;
	long count;
	
	
	public List<SearchResultModel> getListCompResponse() {
		return listCompResponse;
	}
	public void setListCompResponse(List<SearchResultModel> listCompResponse) {
		this.listCompResponse = listCompResponse;
	}

	public void addCompResponse(SearchResultModel compResponse) {
		this.listCompResponse.add(compResponse);
	}
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}

}
