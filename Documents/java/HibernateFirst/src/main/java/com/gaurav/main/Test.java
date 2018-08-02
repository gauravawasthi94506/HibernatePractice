package com.gaurav.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gaurav.entity.Address;
import com.gaurav.entity.EmployeeDetails;

public class Test {
	public static void main(String args[])
	{
		
		EmployeeDetails ed=new EmployeeDetails();
		
		Address adr=new Address();
		ed.setUserName("Gaurav");
		adr.setCity("RBL");
		adr.setDate(new Date());
		adr.setPincode(222222);
		adr.setState("UP");
		adr.setStreet("CHC");
		ed.setAdr_home(adr);
		
		
		
		
		
		
		
		
		Address adr1=new Address();
		ed.setUserName("Gaurav1");
		adr1.setCity("RBL1");
		adr1.setDate(new Date());
		adr1.setPincode(2222221);
		adr1.setState("UP1");
		adr1.setStreet("CHC1");
		ed.setAdr_office(adr1);
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(ed);
		session.getTransaction().commit();
		session.close();
		
	}
}
