package io.dhawal.restdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.dhawal.restdemo.entity.Patient;
import io.dhawal.restdemo.service.PatientService;

@RestController
@RequestMapping(value = "patient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PatientController {

	@Autowired
	private PatientService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Patient> showAll() {
		return service.showAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{patientID}")
	public Patient findOne(@PathVariable("patientID") String patientID) {
		return service.findOne(patientID);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Patient create(@RequestBody Patient patient) {
		return service.create(patient);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{patientID}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Patient update(@PathVariable("patientID") String patientID, @RequestBody Patient patient) {
		return service.update(patientID, patient);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{patientID}")
	public void delete(@PathVariable("patientID") String patientID) {
		service.remove(patientID);
	}
}
