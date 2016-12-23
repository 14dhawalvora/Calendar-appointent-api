package io.dhawal.restdemo.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "Appointments.findAppointment", query = "Select a from Appointments a WHERE a.doctor.doctorID=:aDoctor AND a.date=:aDate"),
		@NamedQuery(name = "Appointments.findAll", query = "Select a from Appointments a") 
})
public class Appointments {

	@Id
	private String appointmentID;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String time;

	private String subject;

	private String notes;

	private Doctor doctor;

	private Patient patient;

	public Appointments() {
		appointmentID = UUID.randomUUID().toString();
	}

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
