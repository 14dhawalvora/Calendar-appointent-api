package io.dhawal.restdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.dhawal.restdemo.entity.Doctor;
import io.dhawal.restdemo.service.DoctorService;

@RestController
@RequestMapping(value = "doctor", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DoctorController {

	@Autowired
	private DoctorService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Doctor> showAll() {
		return service.showAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{doctorID}")
	public Doctor findOne(@PathVariable("doctorID") String doctorID) {
		return service.findOne(doctorID);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Doctor create(@RequestBody Doctor doc) {
		return service.create(doc);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{doctorID}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Doctor update(@PathVariable("doctorID") String doctorID, @RequestBody Doctor doc) {
		return service.update(doctorID, doc);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{doctorID}")
	public void delete(@PathVariable("doctorID") String doctorID) {
		service.remove(doctorID);
	}
}
