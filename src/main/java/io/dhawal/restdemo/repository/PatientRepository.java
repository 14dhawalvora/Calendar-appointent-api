package io.dhawal.restdemo.repository;

import java.util.List;

import io.dhawal.restdemo.entity.Patient;


public interface PatientRepository {

	Patient findPatient(String patientID);

	Patient create(Patient patient);

	Patient update(Patient patient);

	void delete(Patient existing);

	List<Patient> showAll();

}
