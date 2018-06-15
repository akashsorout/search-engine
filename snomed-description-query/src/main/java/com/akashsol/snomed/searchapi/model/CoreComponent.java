package com.akashsol.snomed.searchapi.model;

import java.util.Date;

public abstract class CoreComponent extends Component {

	protected Long id;

	protected CoreComponent() {
		
	}
	
	protected CoreComponent(Long id,Date effectiveTime, byte active, Long moduleId) {
		super(effectiveTime, active, moduleId);
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
