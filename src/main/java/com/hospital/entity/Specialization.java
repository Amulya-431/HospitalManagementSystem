package com.hospital.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Specialization 
{
	@Id
	private String specializationId;
	private String specializationName;
	@OneToMany(mappedBy="spl",cascade=CascadeType.ALL)
	List<Doctor> doctorslist=new ArrayList<Doctor>();
	
	
	public Specialization() {
		super();
		
	}
	
	public Specialization(String specializationId) {
		super();
		this.specializationId = specializationId;
	}

	public String getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(String specializationId) {
		this.specializationId = specializationId;
	}
	public String getSpecializationName() {
		return specializationName;
	}
	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
	public List<Doctor> getDoctorslist() {
		return doctorslist;
	}
	public void setDoctorslist(List<Doctor> doctorslist) {
		this.doctorslist = doctorslist;
	}

	@Override
	public String toString() {
		return "Specialization [specializationId=" + specializationId + ", specializationName=" + specializationName
				+ "]";
	}
	
}
