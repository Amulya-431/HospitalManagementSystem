package com.hospital.service;

import java.time.format.DateTimeParseException;
import com.hospital.entity.Appointments;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.entity.Specialization;
import com.hospital.exception.ForiegnKeyException;

public interface Service {
	
	public void insertDoctor(Doctor d);
	public void insertPatient(Patient p) throws DateTimeParseException;
	public void insertAppointments(Appointments a) throws Exception;
	public void insertSpecialization(Specialization s);
	
	public int updatePatient(Patient p);
	public int updateAppointments(Appointments a) throws Exception;
	
	public int deletePatient(Patient p) throws ForiegnKeyException,Exception;
	public int deleteAppointments(Appointments a);
	
	public int getDoctor(String id);
	public int findPatientbyId(Integer id);	
	public int getAppointments(String id);
	public int getSpecialization(String id);
	
	public int displayPatient();
	public boolean displayDoctor();
	public int displayAppointments();
	public int displaySpecialization();
}
