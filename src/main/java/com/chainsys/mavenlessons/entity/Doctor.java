package com.chainsys.mavenlessons.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Doctor")
public class Doctor {
	@Id
	@Column(name = "doctor_id")
	private int id;
	private String name;
	private Date dob;
	private String speciality;
	private String city;
	private long phone_number;
	@Column(name = "std_fees")
	private float std_fees;
    // Bidirectional Association
	
	@OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Appointment> appointments;


	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public float getStd_fees() {
		return std_fees;
	}

	public void setStd_fees(float std_fees) {
		this.std_fees = std_fees;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	@Override
	public String toString() {
		return String.format("%d,%s,%s,%s,%s,%d,%.2f", id, name, dob, speciality, city, phone_number,
				std_fees);
	}
}
