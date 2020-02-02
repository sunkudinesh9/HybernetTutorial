package com.dineshkearnings.hybernet_tutorial;

import javax.persistence.Embeddable;

@Embeddable // This annotation is Used to add to the existing table
public class FullName {
	private String fname;
	private String lName;
	private String mName;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	@Override
	public String toString() {
		return "FullName [fname=" + fname + ", lName=" + lName + ", mName=" + mName + "]";
	}

}
