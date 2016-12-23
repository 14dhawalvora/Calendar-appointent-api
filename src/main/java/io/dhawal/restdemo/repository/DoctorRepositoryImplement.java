package io.dhawal.restdemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.dhawal.restdemo.entity.Doctor;

@Repository
public class DoctorRepositoryImplement implements DoctorRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Doctor> showAll() {
		TypedQuery<Doctor> query = em.createNamedQuery("Doctor.findAll", Doctor.class);
		return query.getResultList();
	}

	@Override
	public Doctor create(Doctor doc) {
		em.persist(doc);
		return doc;
	}

	@Override
	public Doctor findDoc(String doctorID) {
		return em.find(Doctor.class, doctorID);
	}

	@Override
	public Doctor update(Doctor doc) {
		em.merge(doc);
		return doc;
	}

	@Override
	public void delete(Doctor existing) {
		em.remove(existing);
	}

}
