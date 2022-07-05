package com.chainsys.mavenlessons.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;

@RestController
public class AppointmentControl  {
	@Autowired
	private AppointmentRepository repo;
	
	/* @GetMapping(value="/fetchdoctorbyappointmentid")
	public String getDoctorByAppointmentId(int id) {
		List<Appointment> ap = repo.getByDoctorId(id);
		Iterator<Appointment> itr = ap.iterator();
		String out ="";
		while(itr.hasNext()) {
			Appointment ap1 = itr.next();
			out += ap1;
		}
		return out;
	}  */
	
	@GetMapping(value = "/getdoctorbyappointmentid")
    public String getDoctorByAppointmentId(int id) {
        Appointment app = repo.findById(id);
        Doctor doc = app.getDoctor();
        return doc.toString();
    }
	
	@GetMapping("/getappointment")
	public Appointment getAppointment(int id) {
		return repo.findById(id);
	}
/*	@GetMapping(value = "/fetchappointmentbydoctor")
	public List<Appointment> getAppointmentByDocId(int id) {
		return repo.findAllByDoctorId(id);
	}  */
	@DeleteMapping("/deleteappointment")
	public RedirectView deleteAppointment(int id) {
		 repo.deleteById(id);
		 return new RedirectView("/getallappointment");
	}
	@PostMapping(value = "/newappointment", consumes = "application/json" )
	// we need give from where to read data from the HTTP request and also the content type ("application/json")  
	public RedirectView addAppointment(@RequestBody Appointment ap)
	{
	 repo.save(ap);
	 return new RedirectView("/getallappointment");
	 
	}
	@PutMapping(value = "/modifyappointment", consumes = "application/json" )
	public RedirectView modifyDoctor(@RequestBody Appointment ap)
	{
	 repo.save(ap);
	 return new RedirectView("/getallappointment");
	 
	}
	@GetMapping("/getallappointment")
	public List<Appointment> getAppointments(){
		return repo.findAll();
	}  
}
