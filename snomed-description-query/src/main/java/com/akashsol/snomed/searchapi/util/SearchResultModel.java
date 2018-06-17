package com.akashsol.snomed.searchapi.util;

import com.akashsol.snomed.searchapi.model.Description;

public class SearchResultModel {

	Description description;
	float score;
	
	
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
}
