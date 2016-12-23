package io.dhawal.restdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.dhawal.restdemo.entity.Doctor;
import io.dhawal.restdemo.exception.EntityNotFoundException;
import io.dhawal.restdemo.repository.DoctorRepository;

@Service
public class DoctorServiceImplement implements DoctorService{
	
	@Autowired
	private DoctorRepository repository;

	@Override
	public List<Doctor> showAll() {
		return repository.showAll();
	}

	@Override
	public Doctor findOne(String doctorID) {
		Doctor doc = repository.findDoc(doctorID);
		if (doc == null) {
			throw new EntityNotFoundException("Doctor not found");
		}

		return doc;
	}

	@Transactional
	@Override
	public Doctor create(Doctor doc) {
		return repository.create(doc);
	}

	@Transactional
	@Override
	public Doctor update(String doctorID, Doctor doc) {
		Doctor existing = repository.findDoc(doctorID);
		if (existing == null) {
			throw new EntityNotFoundException("Doctor not found to update");
		}

		return repository.update(doc);
	}

	@Transactional
	@Override
	public void remove(String doctorID) {
		Doctor existing = repository.findDoc(doctorID);
		if (existing == null) {
			throw new EntityNotFoundException("Doctor not found to remove");
		}

		repository.delete(existing);
	}
}
