package io.dhawal.restdemo.service;

import java.util.List;

import io.dhawal.restdemo.entity.Doctor;

public interface DoctorService {

	List<Doctor> showAll();

	Doctor findOne(String doctorID);

	Doctor create(Doctor doc);

	Doctor update(String doctorID, Doctor doc);

	void remove(String doctorID);

}
