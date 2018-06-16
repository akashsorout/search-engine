package com.akashsol.snomed.searchapi.model;


import org.springframework.data.annotation.Id;

public abstract class CoreComponent extends Component {

	@Id
	protected Long id;

	protected CoreComponent() {
		
	}
	
	protected CoreComponent(Long id,String effectiveTime, byte active, Long moduleId) {
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
