package io.dhawal.restdemo.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries(
	@NamedQuery(name="Doctor.findAll",query="Select d from Doctor d ORDER BY d.firstName"))
public class Doctor {
	
	@Id
	private String doctorID;
	
	private String firstName;
	
	private String lastName;
	
	private String specialization;
	
	private Set<Patient> patientList;

	public Doctor(){
		doctorID = UUID.randomUUID().toString();
		patientList=new HashSet<Patient>();
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Set<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}
}
