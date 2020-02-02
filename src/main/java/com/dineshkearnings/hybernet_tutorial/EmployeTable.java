package com.dineshkearnings.hybernet_tutorial;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Table")
public class EmployeTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Embedded
	private FullName name;
	@OneToOne(cascade = CascadeType.ALL)
	private Vehical vehical;

	public Vehical getVehical() {
		return vehical;
	}

	public void setVehical(Vehical vehical) {
		this.vehical = vehical;
	}

	private int salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FullName getName() {
		return name;
	}

	public void setName(FullName name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeTable [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
