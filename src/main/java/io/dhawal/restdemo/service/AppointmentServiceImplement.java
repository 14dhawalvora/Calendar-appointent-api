package io.dhawal.restdemo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.dhawal.restdemo.entity.Appointments;
import io.dhawal.restdemo.exception.EntityNotFoundException;
import io.dhawal.restdemo.repository.AppointmentRepository;

@Service
public class AppointmentServiceImplement implements AppointmentService{
	
	@Autowired
	private AppointmentRepository repository;

	@Transactional
	@Override
	public Appointments create(Appointments app) {
		return repository.create(app);
	}

	@Transactional
	@Override
	public Appointments update(String appointmentID, Appointments app) {
		Appointments existing = repository.findAppointment(appointmentID);
		if (existing == null) {
			throw new EntityNotFoundException("Appointment not found to update");
		}

		return repository.update(app);
	}

	@Transactional
	@Override
	public void remove(String appointmentID) {
		Appointments existing = repository.findAppointment(appointmentID);
		if (existing == null) {
			throw new EntityNotFoundException("Appointment not found to remove");
		}

		repository.delete(existing);
	}

	@Override
	public List<Appointments> getApointmentsByDoctorAndDate(String doctorID, String date) {
		List<Appointments> app = repository.findAppByDoctorAndDate(doctorID,date);
		if (app == null) {
			throw new EntityNotFoundException("Appointment not found selection");
		}

		return app;
	}

	@Override
	public List<Appointments> showAll() {
		return repository.showAll();
	}
}
