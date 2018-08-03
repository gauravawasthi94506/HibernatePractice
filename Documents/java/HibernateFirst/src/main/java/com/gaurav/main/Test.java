package com.gaurav.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gaurav.entity.Address;
/*import com.gaurav.entity.EmployeeDetails;*/
import com.gaurav.entity.EmployeeDetails;
import com.gaurav.entity.Vehicle;


public class Test {
	public static void main(String args[])
	{
		System.out.println("exception occured");
	
		EmployeeDetails ed=new EmployeeDetails();
		ed.setUserName("gauravAwasthi");
		Vehicle vc=new Vehicle();
		vc.setVehicleName("maruti");
		
		
		Vehicle vc1=new Vehicle();
		vc1.setVehicleName("Jeep");
		
		ed.getSvc().add(vc);
		ed.getSvc().add(vc1);
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(ed);
		session.save(vc);
		session.save(vc1);
		session.getTransaction().commit();
		session.close();
		
		
	}
}
