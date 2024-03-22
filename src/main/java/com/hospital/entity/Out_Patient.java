
package com.hospital.entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("out_patient")

public class Out_Patient extends Patient 
{
	private String diagnosis;
    
	public Out_Patient() {
		super();
		
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString() {
		return "Out_Patient [diagnosis=" + diagnosis + ", toString()=" + super.toString() + "]";
	}
	

}
