package com.hospital;
import java.time.LocalDate;
import java.util.Scanner;

import com.hospital.entity.Appointments;
import com.hospital.entity.Doctor;
import com.hospital.entity.In_Patient;
import com.hospital.entity.Out_Patient;
import com.hospital.entity.Patient;
import com.hospital.entity.Specialization;
import com.hospital.service.Service;
import com.hospital.service.ServiceImpl;

public class Implementation
{
	public static void main(String args[]) throws Exception
	{
	System.out.println("Welcome to the hospital management system");
	Scanner sc=new Scanner(System.in);
	System.out.println("You are 1.User 2.Admin \nEnter Choice");
	int user = sc.nextInt();
	
	Service service = new ServiceImpl();
	
	if (user == 1) 
	{
     System.out.println("1.get patient details");
     System.out.println("2.get doctor details");
     System.out.println("3.get Appointments details");
     System.out.println("4.get specialization details \nenter choice:");
     int a = sc.nextInt();
     while (a > 0) 
     {
		switch (a) 
			
     {
     case 1:
    	 Integer pid;
    	 System.out.println("enter patient id:");
    	 pid=sc.nextInt();
    	 service.findPatientbyId(pid);
         break;
     case 2:
     String did;
     System.out.println("enter doctor id:");
     did=sc.next();
     service.getDoctor(did);
     break;
     case 3:
     String aid;
     System.out.println("enter appointment id:");
     aid=sc.next();
     service.getAppointments(aid);
     break;
     case 4:
    	 String sid;
    	 System.out.println("enter specialization id:");
         sid=sc.next();
         service.getSpecialization(sid);
    	 break;
    	 
    default:System.out.println("invalid option");
            break;
     }
		System.out.println("1.get patient details");
	    System.out.println("2.get doctor details");
	    System.out.println("3.get Appointments details");
	    System.out.println("4.get specialization details\n Press 0 to exit");
	    a = sc.nextInt();
     }
	}
	else if (user == 2) 
	{
		System.out.println("1.get patient details");
	    System.out.println("2.get doctor details");
	    System.out.println("3.get Appointments details");
	    System.out.println("4.get specialization details");
		System.out.println("5.insert specialization \n6.insert doctor");
		System.out.println("7.insert patient \n8.insert in_patient \n9.insert out_patient");
		System.out.println("10.insert appointment details");
		System.out.println("11.update patient \n12.update in_patient \n13.update out_patient");
	    System.out.println("14.update appointments");
		System.out.println("15.delete patient \n16.delete appointments");
		System.out.println("17.display all doctor table records");
		System.out.println("18.display all patients records");
		System.out.println("19.display all appointments");
		System.out.println("20.display all specializations");
		System.out.println("enter choice");
		int a = sc.nextInt();
		while (a > 0) 
		{
			switch (a) 
			{
             case 1: 
                  Integer pid;
        	      System.out.println("enter patient id:");
        	      pid=sc.nextInt();
                  service.findPatientbyId(pid);
                  
             break;
             case 2:
            	 String did;
                 System.out.println("enter doctor id:");
                 did=sc.next();
                 service.getDoctor(did);
                 break;
			case 3:
				 String aid;
			     System.out.println("enter appointment id:");
			     aid=sc.next();
			     service.getAppointments(aid);
			     break;
			case 4:
				 String sid;
		    	 System.out.println("enter specialization id:");
		         sid=sc.next();
		         service.getSpecialization(sid);
		    	 break;
			case 5:
				Specialization s1=new Specialization();
				System.out.println("enter specialization Id");
				s1.setSpecializationId(sc.next());
				System.out.println("enter specialization name");
				s1.setSpecializationName(sc.next());
				service.insertSpecialization(s1);
				break;
			case 6:
				Doctor d1= new Doctor();
				System.out.println("enter Doctor id");
				d1.setDoctorId(sc.next());
			    System.out.println("enter doctor name");
			    d1.setDoctorName(sc.next());
			    System.out.println("enter doctor gender");
			    d1.setGender(sc.next());
			    System.out.println("enter doctor qualification");
			    d1.setQualification(sc.next());
			    
			    Specialization s3=new Specialization();
			    System.out.println("enter id");
			    String idSpl=sc.next();
			    s3.setSpecializationId(idSpl);
			    d1.setSpl(s3);
			    
			    service.insertDoctor(d1);
			    s3.getDoctorslist().add(d1);
			    
			    break;
			case 7:
				Patient p1=new Patient();
				System.out.println("enter patient first name");
				p1.setFirstName(sc.next());
				System.out.println("enter patient last name");
				p1.setLastName(sc.next());
				System.out.println("enter patient gender");
				p1.setGender(sc.next());
				System.out.println("enter patient age");
				p1.setAge(sc.nextInt());
				System.out.println("enter patient address");
				p1.setAddress(sc.next());
				
				Doctor dr=new Doctor();
			    System.out.println("enter doctor id");
			    String sdr=sc.next();
			    dr.setDoctorId(sdr);
			    
				p1.setDoctor(dr); 
				
				service.insertPatient(p1);
				dr.getPatientlist().add(p1);
				break;
			case 8:
				In_Patient p2=new In_Patient();

				System.out.println("enter in patient first name");				
				p2.setFirstName(sc.next());
				System.out.println("enter in patient last name");
				p2.setLastName(sc.next());
				System.out.println("enter in patient gender");
				p2.setGender(sc.next());
				System.out.println("enter in patient age");
				p2.setAge(sc.nextInt());
				System.out.println("enter in patient address");
				p2.setAddress(sc.next());
				System.out.println("enter date of admit");
				String dofa1=sc.next();
				LocalDate pdt2=LocalDate.parse(dofa1);
				p2.setDate_of_admit(pdt2);
				System.out.println("enter date of discharge");
				String das=sc.next();
				LocalDate dt=LocalDate.parse(das);
				p2.setDate_of_discharge(dt);
				System.out.println("enter advance payment");
				p2.setAdvancePayment(sc.nextDouble());
			    System.out.println("enter disease");
			    p2.setDisease(sc.next());
			    
			    Doctor dtr=new Doctor();
			    System.out.println("enter doctor id");
			    dtr.setDoctorId(sc.next());
			    
				p2.setDoctor(dtr); 
			    
			    service.insertPatient(p2);
			    dtr.getPatientlist().add(p2);
			    break;
			case 9:
				Out_Patient p3=new Out_Patient();
				System.out.println("enter out patient first name");
				p3.setFirstName(sc.next());
				System.out.println("enter out patient last name");
				p3.setLastName(sc.next());
				System.out.println("enter out patient gender");
				p3.setGender(sc.next());
				System.out.println("enter out patient age");
				p3.setAge(sc.nextInt());
				System.out.println("enter out patient address");
				p3.setAddress(sc.next());
				
				System.out.println("enter diagnosis");
				p3.setDiagnosis(sc.next());
				
				Doctor dr1=new Doctor();
			    System.out.println("enter doctor id");
			    dr1.setDoctorId(sc.next());
			    
				p3.setDoctor(dr1); 
				
				service.insertPatient(p3);
				dr1.getPatientlist().add(p3);
				break;
			case 10:
				Appointments a1=new Appointments();
				System.out.println("enter appointment id");
				a1.setAppointmentId(sc.next());
				System.out.println("enter appointment date");
				String dat=sc.next();
				LocalDate dap=LocalDate.parse(dat);
				a1.setAppointmentDate(dap);
				
				Patient pt1=new Patient();
				System.out.println("enter patient id");
				pt1.setPatientId(sc.nextInt());
				a1.setPatient(pt1);
                pt1.getPtappointlist().add(a1);
                
				Doctor dr2=new Doctor();
			    System.out.println("enter doctor id");
			    dr2.setDoctorId(sc.next());		    
				a1.setDcr(dr2);
				
				service.insertAppointments(a1);
				
				dr2.getDlist().add(a1);
				break;
			case 11:
				Patient p4=new Patient();
				System.out.println("enter patient id");
				p4.setPatientId(sc.nextInt());
				System.out.println("enter patient first name");
				p4.setFirstName(sc.next());
				System.out.println("enter patient last name");
				String lastname=sc.next();
				p4.setLastName(lastname);
				System.out.println("enter patient gender");
				p4.setGender(sc.next());
				System.out.println("enter patient age");
				p4.setAge(sc.nextInt());
				System.out.println("enter patient address");
				p4.setAddress(sc.next());
				
				
				Doctor dtr3=new Doctor();
			    System.out.println("enter doctor id");
			    dtr3.setDoctorId(sc.next());
				p4.setDoctor(dtr3);
			    
      		    service.updatePatient(p4);
      		    
				break;
			case 12:
				In_Patient p5=new In_Patient();
				System.out.println("enter in patient id");
				p5.setPatientId(sc.nextInt());
				System.out.println("enter in patient first name");
				p5.setFirstName(sc.next());
				System.out.println("enter in patient last name");
				p5.setLastName(sc.next());
				System.out.println("enter in patient gender");
				p5.setGender(sc.next());
				System.out.println("enter in patient age");
				p5.setAge(sc.nextInt());
				System.out.println("enter in patient address");
				p5.setAddress(sc.next());
				System.out.println("enter date of admit");
				String dofa=sc.next();
				LocalDate pdt1=LocalDate.parse(dofa);
				p5.setDate_of_admit(pdt1);
				System.out.println("enter date of discharge");
				String pdas=sc.next();
				LocalDate pdt=LocalDate.parse(pdas);
				p5.setDate_of_discharge(pdt);
				System.out.println("enter advance payment");
				p5.setAdvancePayment(sc.nextDouble());
			    System.out.println("enter disease");
			    p5.setDisease(sc.next());
			    
			    Doctor dtr4=new Doctor();
			    System.out.println("enter doctor id");
			    dtr4.setDoctorId(sc.next());
				p5.setDoctor(dtr4);
			    
		    
			    service.updatePatient(p5);
			    break;
			    
			case 13:
				Out_Patient p6=new Out_Patient();
				System.out.println("enter patient id");
				p6.setPatientId(sc.nextInt());
				System.out.println("enter out patient first name");			
				p6.setFirstName(sc.next());
				System.out.println("enter out patient last name");
				p6.setLastName(sc.next());
				System.out.println("enter out patient gender");
				p6.setGender(sc.next());
				System.out.println("enter out patient age");
				p6.setAge(sc.nextInt());
				System.out.println("enter out patient address");
				p6.setAddress(sc.next());
				System.out.println("enter diagnosis");
				
				p6.setDiagnosis(sc.next());
				
			    Doctor dtr5=new Doctor();
			    System.out.println("enter doctor id");
			    
		        dtr5.setDoctorId(sc.next());
		   		p6.setDoctor(dtr5);
				 

				service.updatePatient(p6);
				break;
			case 14:
				Appointments a2=new Appointments();
				System.out.println("enter appointment id");
				a2.setAppointmentId(sc.next());
				System.out.println("enter appointment date");
				String adate=sc.next();
				LocalDate adat=LocalDate.parse(adate);
				a2.setAppointmentDate(adat);
				
				Patient pt2=new Patient();
				System.out.println("enter patient id");		
				pt2.setPatientId(sc.nextInt());
				a2.setPatient(pt2);
                
                
				Doctor dr3=new Doctor();
			    System.out.println("enter doctor id");   
			    dr3.setDoctorId(sc.next());		    
				a2.setDcr(dr3);
				
				service.updateAppointments(a2);
				break;
			case 15:
				Patient patient=new Patient();
				System.out.println("enter pateint Id which needs to be deleted");
				patient.setPatientId(sc.nextInt());
				service.deletePatient(patient);
				break;
			case 16:
				Appointments appoint=new Appointments();
				System.out.println("enter appointmentId to be deleted");				
				appoint.setAppointmentId(sc.next());
				service.deleteAppointments(appoint);
				break;
			case 17:
				service.displayDoctor();
				break;
			case 18:
				service.displayPatient();
				break;
			case 19:
				service.displayAppointments();
			    break;
			case 20:
				service.displaySpecialization();
				break;
			default:
				System.out.println("invalid option");
				break;
			}
			
			System.out.println("1.get patient details");
		    System.out.println("2.get doctor details");
		    System.out.println("3.get Appointments details");
		    System.out.println("4.get specialization details");
		    System.out.println("5.insert specialization \n6.insert doctor");
			System.out.println("7.insert patient \n8.insert in_patient \n9.insert out_patient");
			System.out.println("10.insert appointment details");
			System.out.println("11.update patient \n12.update in_patient \n13.update out_patient");
		    System.out.println("14.update appointments");
			System.out.println("15.delete patient \n16.delete appointments");
			System.out.println("17.display all doctor table records");
			System.out.println("18.display all patients records");
			System.out.println("19.display all appointments");
			System.out.println("20.display all specializations");
			System.out.println("enter choice \nPress 0 to exit");
			
		    a = sc.nextInt();
		}
	}
	sc.close();	
	

	} 
}
