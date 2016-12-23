package io.dhawal.restdemo.service;

import java.util.List;

import io.dhawal.restdemo.entity.Patient;

public interface PatientService {

	List<Patient> showAll();

	Patient findOne(String patientID);

	Patient create(Patient patient);

	Patient update(String patientID, Patient patient);

	void remove(String patientID);

}
