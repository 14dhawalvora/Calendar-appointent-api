package io.dhawal.restdemo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.dhawal.restdemo.entity.Appointments;
import io.dhawal.restdemo.service.AppointmentService;

@RestController
@RequestMapping(value = "appointment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppointmentsController {
	
	@Autowired
	private AppointmentService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Appointments create(@RequestBody Appointments app){
		return service.create(app);
		 
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{appointmentID}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Appointments update(@PathVariable("appointmentID") String appointmentID, @RequestBody Appointments app){
		return service.update(appointmentID,app);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{appointmentID}")
	public void delete(@PathVariable("appointmentID") String appointmentID){
		service.remove(appointmentID);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search/{doctorID}/{date}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Appointments> getApointmentsByDoctorAndDate(@PathVariable("doctorID") String doctorID, @PathVariable("date") String date){
		return service.getApointmentsByDoctorAndDate(doctorID,date);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "showall")
	public List<Appointments> showAll(){
		return service.showAll();
	}
}
