 package com.hospital.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="patient")
@NamedQuery(name="find Patient",query=" from Patient where patientId=:id")

public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
	private Integer patientId;
    private String firstName;
    private String lastName;
	private String gender;
	private Integer age;
	private String address;
	
	public Patient()
	{
		
	}
	@ManyToOne
	@JoinColumn(name="doctorId")
	private Doctor doctor;
	
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
	List<Appointments> ptappointlist=new ArrayList<Appointments>();
	
	public List<Appointments> getPtappointlist() {
		return ptappointlist;
	}

	public void setPtappointlist(List<Appointments> ptappointlist) {
		this.ptappointlist = ptappointlist;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", age=" + age + ", address=" + address + "]";
	}
	
	
}