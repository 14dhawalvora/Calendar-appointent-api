package io.dhawal.restdemo.repository;

import java.util.List;

import io.dhawal.restdemo.entity.Doctor;

public interface DoctorRepository {

	List<Doctor> showAll();

	Doctor create(Doctor doc);

	Doctor findDoc(String doctorID);

	Doctor update(Doctor doc);

	void delete(Doctor existing);

}
