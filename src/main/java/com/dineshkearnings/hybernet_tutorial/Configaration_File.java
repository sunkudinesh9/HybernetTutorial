package com.dineshkearnings.hybernet_tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Configaration_File {
	Configuration con = new Configuration().configure().addAnnotatedClass(EmployeTable.class);
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	SessionFactory sf = con.buildSessionFactory(registry);
	public Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	public EmployeTable emp = null;
	public FullName fullName = null;

	public void addEmployee() {
		FullName fullName = new FullName();
		fullName.setFname("Sunku");
		fullName.setlName("Kumar");
		fullName.setmName("Tharun");
		
		emp = new EmployeTable();
		emp.setName(fullName);
		emp.setSalary(20000);
		Vehical vehical = new Vehical();
		vehical.setVehicalName("car");

		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicalName("Bike");
		twoWheeler.setSteeringHandle("FZ");

		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicalName("Car");
		fourWheeler.setStreeingWheel("Benz");

		emp.setVehical(vehical);

		session.save(vehical);
		session.save(twoWheeler);
		session.save(fourWheeler);
		session.save(emp);
		tx.commit();
	}

	public EmployeTable getEmployeeData(int id) {
		return session.get(EmployeTable.class, id);
	}

	public static void main(String[] args) {
		Configaration_File cf = new Configaration_File();
		cf.addEmployee();

	}
}
