package com.hospital.entity;

import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("in_patient")

public class In_Patient extends Patient
{
	private LocalDate date_of_admit;
	private LocalDate date_of_discharge;
	private Double advancePayment;
	private String disease;
	
	public In_Patient() {
		super();
	}
	public LocalDate getDate_of_admit() {
		return date_of_admit;
	}
	public void setDate_of_admit(LocalDate date_of_admit) {
		this.date_of_admit = date_of_admit;
	}
	public LocalDate getDate_of_discharge() {
		return date_of_discharge;
	}
	public void setDate_of_discharge(LocalDate date_of_discharge) {
		this.date_of_discharge = date_of_discharge;
	}
	public Double getAdvancePayment() {
		return advancePayment;
	}
	public void setAdvancePayment(Double advancePayment) {
		this.advancePayment = advancePayment;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	@Override
	public String toString() {
		return "In_Patient [date_of_admit=" + date_of_admit + ", date_of_discharge=" + date_of_discharge
				+ ", advancePayment=" + advancePayment + ", disease=" + disease + ", toString()=" + super.toString()
				+ "]";
	}
	
}
