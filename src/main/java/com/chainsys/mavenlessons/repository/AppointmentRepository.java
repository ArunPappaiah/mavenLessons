package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment,Integer>{
	Appointment findById(int id);
	Appointment save(Appointment ap);
	// Used for both adding new Doctor and Modifying Doctor
	void deleteById(int id);
	List <Appointment> findAll();
	// @Query(value="select a from Appointment a where a.doctor_id=?1")
	// JPQL- Java Persistent Query Language
	// Here (a) is an instance of Appointment 
	//  List<Appointment> findAllByDoctorId(int drId);
	// List<Appointment>  getByDoctorId(int dr_id);
}
