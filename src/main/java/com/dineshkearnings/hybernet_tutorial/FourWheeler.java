package com.dineshkearnings.hybernet_tutorial;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehical {
	private String streeingWheel;

	public String getStreeingWheel() {
		return streeingWheel;
	}

	public void setStreeingWheel(String streeingWheel) {
		this.streeingWheel = streeingWheel;
	}

}
