package com.akashsol.snomed.searchapi.model;

import java.util.Date;

public abstract class Component {

	protected Date effectiveTime;
	protected byte active;
	protected Long moduleId;
	
	protected Component() {
		
	}
	
	
	protected Component(Date effectiveTime, byte active, Long moduleId) {
		super();
		this.effectiveTime = effectiveTime;
		this.active = active;
		this.moduleId = moduleId;
	}
	
	
	public Date getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

		
	
}
