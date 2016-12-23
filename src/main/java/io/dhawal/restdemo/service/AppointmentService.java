package io.dhawal.restdemo.service;

import java.util.Date;
import java.util.List;

import io.dhawal.restdemo.entity.Appointments;


public interface AppointmentService {

	Appointments create(Appointments app);

	Appointments update(String appointmentID, Appointments app);

	void remove(String appointmentID);

	List<Appointments> getApointmentsByDoctorAndDate(String doctorID, String date);

	List<Appointments> showAll();

}
