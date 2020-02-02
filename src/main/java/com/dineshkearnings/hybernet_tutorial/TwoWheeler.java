package com.dineshkearnings.hybernet_tutorial;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehical {
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
