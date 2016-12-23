package io.dhawal.restdemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.dhawal.restdemo.entity.Patient;


@Repository
public class PatientRepositoryImplement implements PatientRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Patient findPatient(String patientID) {
		return em.find(Patient.class, patientID);
	}

	@Override
	public Patient create(Patient patient) {
		em.persist(patient);
		return patient;
	}

	@Override
	public Patient update(Patient patient) {
		em.merge(patient);
		return patient;
	}

	@Override
	public void delete(Patient existing) {
		em.remove(existing);
	}

	@Override
	public List<Patient> showAll() {
		TypedQuery<Patient> query = em.createNamedQuery("Patient.findAll", Patient.class);
		return query.getResultList();
	}

}
