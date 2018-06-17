package com.akashsol.snomed.searchapi.model;

import org.springframework.data.elasticsearch.annotations.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Document(indexName = "snomedct", type = "description")
@ApiModel
public class Description extends CoreComponent{
		
		private	Long conceptId;
		private	String languageCode;
		
		@ApiModelProperty(value="Type of Description <br>FSN : 900000000000003001 <br>Synonym : 900000000000013009",position=1)
		private	Long typeId;
		
		@ApiModelProperty(required=true,value="Clinical term present in SNOMED CT : fever",position=0)
		private	String term;
		private	Long caseSignificanceId;
		
		public Description() {
		
		}
		
		
		public Description(Long id,String effectiveTime, int active, Long moduleId,Long conceptId, String languageCode, Long typeId, String term, Long caseSignificanceId) {
			super( id, effectiveTime,  active,  moduleId);
			this.conceptId = conceptId;
			this.languageCode = languageCode;
			this.typeId = typeId;
			this.term = term;
			this.caseSignificanceId = caseSignificanceId;
		}


		public Long getConceptId() {
			return conceptId;
		}


		public void setConceptId(Long conceptId) {
			this.conceptId = conceptId;
		}


		public String getLanguageCode() {
			return languageCode;
		}


		public void setLanguageCode(String languageCode) {
			this.languageCode = languageCode;
		}


		public Long getTypeId() {
			return typeId;
		}


		public void setTypeId(Long typeId) {
			this.typeId = typeId;
		}


		public String getTerm() {
			return term;
		}


		public void setTerm(String term) {
			this.term = term;
		}


		public Long getCaseSignificanceId() {
			return caseSignificanceId;
		}


		public void setCaseSignificanceId(Long caseSignificanceId) {
			this.caseSignificanceId = caseSignificanceId;
		}
		
		
	
}
