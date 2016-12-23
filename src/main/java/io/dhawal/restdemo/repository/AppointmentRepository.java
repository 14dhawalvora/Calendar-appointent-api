package io.dhawal.restdemo.repository;

import java.util.Date;
import java.util.List;

import io.dhawal.restdemo.entity.Appointments;


public interface AppointmentRepository {

	List<Appointments> showAll();

	List<Appointments> findAppByDoctorAndDate(String doctorID, String date);

	Appointments create(Appointments app);

	Appointments update(Appointments app);

	void delete(Appointments existing);

	Appointments findAppointment(String appointmentID);

}
