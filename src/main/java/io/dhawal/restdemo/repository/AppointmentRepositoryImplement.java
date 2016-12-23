package io.dhawal.restdemo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.dhawal.restdemo.entity.Appointments;
import io.dhawal.restdemo.entity.Doctor;


@Repository
public class AppointmentRepositoryImplement implements AppointmentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Appointments> showAll() {
		TypedQuery<Appointments> query = em.createNamedQuery("Appointments.findAll", Appointments.class);
		return query.getResultList();
	}

	@Override
	public List<Appointments> findAppByDoctorAndDate(String doctorID, String date) {
		TypedQuery<Appointments> query = em.createNamedQuery("Appointments.findAppointment", Appointments.class);
		query.setParameter("aDoctor", doctorID);
		Date d = null;
		try {
			d=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
		}
		query.setParameter("aDate", d);
		List<Appointments> appointments=query.getResultList();
		if(appointments.size()>0){
			return appointments;
		}else{
			return null;
		}
	}

	@Override
	public Appointments create(Appointments app) {
		em.persist(app);
		Doctor doc=app.getDoctor();
		doc.getPatientList().add(app.getPatient());
		em.merge(doc);
		return app;
	}

	@Override
	public Appointments update(Appointments app) {
		em.merge(app);
		return app;
	}

	@Override
	public void delete(Appointments existing) {
		em.remove(existing);
	}

	@Override
	public Appointments findAppointment(String appointmentID) {
		return em.find(Appointments.class, appointmentID);
	}

}
