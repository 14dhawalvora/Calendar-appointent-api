package io.dhawal.restdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.dhawal.restdemo.entity.Patient;
import io.dhawal.restdemo.exception.EntityNotFoundException;
import io.dhawal.restdemo.repository.PatientRepository;

@Service
public class PatientServiceImplement implements PatientService {

	@Autowired
	private PatientRepository repository;

	@Override
	public List<Patient> showAll() {
		return repository.showAll();
	}

	@Override
	public Patient findOne(String patientID) {
		Patient patient = repository.findPatient(patientID);
		if (patient == null) {
			throw new EntityNotFoundException("Patient not found");
		}

		return patient;
	}

	@Transactional
	@Override
	public Patient create(Patient patient) {
		return repository.create(patient);
	}

	@Transactional
	@Override
	public Patient update(String patientID, Patient patient) {
		Patient existing = repository.findPatient(patientID);
		if (existing == null) {
			throw new EntityNotFoundException("Patient not found to update");
		}

		return repository.update(patient);
	}

	@Transactional
	@Override
	public void remove(String patientID) {
		Patient existing = repository.findPatient(patientID);
		if (existing == null) {
			throw new EntityNotFoundException("Patient not found to remove");
		}

		repository.delete(existing);
	}
}
