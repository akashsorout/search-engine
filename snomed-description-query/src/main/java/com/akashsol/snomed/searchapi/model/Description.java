package com.akashsol.snomed.searchapi.model;

import java.util.Date;

public class Description extends CoreComponent{
		
		private	Long conceptId;
		private	String languageCode;
		private	Long typeId;
		private	String term;
		private	Long caseSignificanceId;
		
		public Description() {
		
		}
		
		
		
		public Description(Long id,Date effectiveTime, byte active, Long moduleId,Long conceptId, String languageCode, Long typeId, String term, Long caseSignificanceId) {
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
