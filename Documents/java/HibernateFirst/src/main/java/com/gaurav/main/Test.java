package com.gaurav.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gaurav.entity.Address;
/*import com.gaurav.entity.EmployeeDetails;*/
import com.gaurav.entity.EmployeeDetails;


public class Test {
	public static void main(String args[])
	{
		System.out.println("control comes here");
		EmployeeDetails ed=new EmployeeDetails();
		
		Address adr=new Address();
		ed.setUserName("Gaurav");
		adr.setCity("RBL");
		adr.setPincode(222222);
		adr.setState("UP");
		adr.setStreet("CHC");
		
		Address adr1=new Address();
		ed.setUserName("Gaurav1");
		adr1.setCity("RBL1");
		adr1.setPincode(2222221);
		adr1.setState("UP1");
		adr1.setStreet("CHC1");
		System.out.println("control comes here now");
		ed.getListOfAddress().add(adr1);
		ed.getListOfAddress().add(adr);
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(ed);
		session.getTransaction().commit();
		session.close();
		System.out.println("control comes hereagain");
		session=sf.openSession();
		
		EmployeeDetails ed2=session.get(EmployeeDetails.class, 1);
		session.close();
		System.out.println("Selected user are"+ed2.getListOfAddress().size());
		
	}
}
