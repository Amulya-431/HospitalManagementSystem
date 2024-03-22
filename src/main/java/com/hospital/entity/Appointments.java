package com.hospital.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointments 
{
	@Id
	private String appointmentId;
	@Column
	private LocalDate appointmentDate;

	public Appointments() {
		super();
		
	}
	@ManyToOne
	@JoinColumn(name="doctorId")
	private Doctor dcr;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Doctor getDcr() {
		return dcr;
	}
	public void setDcr(Doctor dcr) {
		this.dcr = dcr;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Appointments [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate + "]";
	}
	

}
