package com.hospital.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.hospital.entity.Appointments;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;

public class ServiceImplTest 
{
    ServiceImpl ssimp=new ServiceImpl();
    Patient p=new Patient();
    Appointments at=new Appointments();
    Doctor d=new Doctor();
    
    @Test
    public void displayPatient()
    {
    	int pt=ssimp.displayPatient();
    	assertEquals(1,pt);
    	
    }
    
    @Test
    public void displayDoctor()
    {
    	assertTrue(ssimp.displayDoctor());
    }
    
    @Test
    public void displayAppointments()
    {
    	int da=ssimp.displayAppointments();
    	assertEquals(1,da);
    }
    @Test
    public void displaySpecialization()
    {
    	int da=ssimp.displaySpecialization();
    	assertEquals(1,da);
    }
    @Test
    public void getDoctor() {
    	String id=new String("D1");
    	int i=ssimp.getDoctor(id);
    	assertEquals(1,i);
    }
    @Test
    public void findPatientbyId()
    {
    	
    	int i=ssimp.findPatientbyId(452);
    	assertEquals(1,i);
    	
    }
    @Test
    public void getSpecialization() {
    	int i=ssimp.getSpecialization("S1");
    	assertEquals(1,i);
    }
    @Test
    public void getAppointments()
    {
    	int i=ssimp.getAppointments("A3");
    	assertEquals(1,i);
    }
}