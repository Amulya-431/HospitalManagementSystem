package com.hospital.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Doctor 
{
	@Id
	private String doctorId;
	private String doctorName;
	private String gender;
	private String qualification;
	
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
	List<Patient> patientlist=new ArrayList<Patient>();
	
	@OneToMany(mappedBy="dcr",cascade=CascadeType.ALL)
	List<Appointments> dlist=new ArrayList<Appointments>();
	
	@ManyToOne
	@JoinColumn(name="specializationId")
	private Specialization spl;
	
	
	public Doctor() {
		super();
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public List<Patient> getPatientlist() {
		return patientlist;
	}
	public void setPatientlist(List<Patient> patientlist) {
		this.patientlist = patientlist;
	}
	public List<Appointments> getDlist() {
		return dlist;
	}
	public void setDlist(List<Appointments> dlist) {
		this.dlist = dlist;
	}
	public Specialization getSpl() {
		return spl;
	}
	public void setSpl(Specialization spl) {
		this.spl = spl;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", gender=" + gender + ", qualification="
				+ qualification + "]";
	}
	
	
}
