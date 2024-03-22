package com.hospital.service;

import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hospital.entity.Appointments;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.entity.Specialization;
import com.hospital.exception.ForiegnKeyException;
import com.hospital.utility.UtilityConfig;

public class ServiceImpl implements Service
{
	Session session;
	Transaction transaction;
	
	@Override
	public void insertDoctor(Doctor d) 
	{
		try {
			session=UtilityConfig.getSession();
		    transaction=session.beginTransaction();
			session.save(d);
			transaction.commit();
			System.out.println("inserted a doctor record successfully");
			}
			finally {
			session.close();
			
			}
		
	}
	@Override
	public void insertPatient(Patient p) throws DateTimeParseException {
		try {
			session=UtilityConfig.getSession();
		    transaction=session.beginTransaction();
			session.save(p);
			transaction.commit();
			System.out.println("inserted a patient record successfully");
			}catch(DateTimeParseException e){
				System.out.println("date format is not correct");
		    }
			finally {
			session.close();
			}	
	}
	
	@Override
	public void insertAppointments(Appointments a) throws DateTimeParseException
	{
		try {
			session=UtilityConfig.getSession();
		    transaction=session.beginTransaction();
			session.save(a);
			transaction.commit();
			System.out.println("inserted an appointment of a patient");
			}catch(DateTimeParseException e){
				System.out.println("date format is not correct");
		    }
			finally {
			session.close();
			
			}
		
	}
	@Override
	public void insertSpecialization(Specialization s) 
	{
		try {
			session=UtilityConfig.getSession();
		    transaction=session.beginTransaction();
			session.save(s);
			transaction.commit();
			System.out.println("inserted specialization");
			}
			finally {
			session.close();
			
			}
		
	}
	
	@Override
	public int updatePatient(Patient p) {
		try {
			session=UtilityConfig.getSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(p);
			transaction.commit();
			System.out.println("updated patient details");
			}
			finally
			{
				session.close();
				
			}
		return 1;
	}
	@Override
	public int updateAppointments(Appointments a)
	{
		try {
			session=UtilityConfig.getSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(a);
			transaction.commit();
			System.out.println("updated appointments of patients");
			}
			finally {
				session.close();
				
			}
		return 1;
		
	}
	
	@Override
	public int deletePatient(Patient p) throws PersistenceException,ForiegnKeyException {
		try {
			session=UtilityConfig.getSession();
			transaction=session.beginTransaction();
			session.delete(p);
			transaction.commit();
			System.out.println("deleted details of a patient");
			}catch(PersistenceException e)
		    {
				throw new ForiegnKeyException("patient Id as foriegn key exists in appointments table");
		    }
			finally {
			session.close();
			
			}
		return 1;
	}	
	@Override
	public int deleteAppointments(Appointments a) {
		try {
			session=UtilityConfig.getSession();
			transaction=session.beginTransaction();
			session.delete(a);
			transaction.commit();
			System.out.println("deleted appointment details of a patient");
			}
			finally {
			session.close();
			
			}
		return 1;
	}
	
	@Override
	public int findPatientbyId(Integer id)
	{
		try {
		session=UtilityConfig.getSession();
		Query q=session.createNamedQuery("find Patient");
		q.setParameter("id",id);
		List<Patient> name=q.getResultList();		
		Iterator<Patient> itr=name.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		}
		finally {
			session.close();
		}
		return 1;
	}
	
	@Override
	public int getDoctor(String id) 
	{
		try {
			session=UtilityConfig.getSession();
			Doctor d=session.get(Doctor.class, id);
			System.out.println(d);
		}
		finally {
			session.close();
		}	
		return 1;
	}
	
	@Override
	public int getAppointments(String id) {
		try {
			session=UtilityConfig.getSession();
			Appointments a=session.get(Appointments.class, id);
			System.out.println(a);
		}
		finally {
			session.close();
		}
		return 1;
		
	}
	@Override
	public int getSpecialization(String id) {
		try {
			session=UtilityConfig.getSession();
			Specialization s=session.get(Specialization.class, id);
			System.out.println(s);
		}
		finally {
			session.close();
		}	
		return 1;
		
	}
	
	@Override
	public boolean displayDoctor() {
		try {
		session=UtilityConfig.getSession();
		TypedQuery tq=session.createQuery("from Doctor");
		List<Doctor> list=tq.getResultList();
		Iterator<Doctor> itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		}
		finally
		{
			session.close();
		}
		return true;
	}
	@Override
	public int displayPatient()
	{
		try{
		session=UtilityConfig.getSession();
		TypedQuery tq=session.createQuery("from Patient");
		List<Patient> list=tq.getResultList();
		Iterator<Patient> itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		}
		finally {
			session.close();
		}
		return 1;
	}
	
	@Override
	public int displayAppointments() 
	{
		try {
		session=UtilityConfig.getSession();
		TypedQuery tq=session.createQuery("from Appointments");
		List<Appointments> list=tq.getResultList();
		Iterator<Appointments> itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		}
		finally {
			session.close();
		}
		return 1;
	}
	@Override
	public int displaySpecialization() 
	{
		try {
			session=UtilityConfig.getSession();
			TypedQuery tq=session.createQuery("from Specialization");
			List<Specialization> list=tq.getResultList();
			Iterator<Specialization> itr=list.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
			}
			finally {
				session.close();
			}
		return 1;
	}	
}
