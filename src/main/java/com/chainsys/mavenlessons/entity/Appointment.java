package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointment")
public class Appointment {
	@Id
	@Column(name = "APPOINT_ID")
	private int id;
	 @Column(name="APPOINT_DATE")
	private Date appoint_date;
	@Column(name = "DOCTOR_ID")
	private int doctor_id;
	 @Column(name="patient_name")
	private String patient_name;
	 @Column(name="fees_collected")
	private String fees_collected;

	// JoinColumn maps the column(doctor_id) of the current entity appointment
	// with the primary key column(id) of the associated entity doctor.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Doctor doctor;

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doc) {
		this.doctor = doc;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppoint_date() {
		return appoint_date;
	}

	public void setAppoint_date(Date appoint_date) {
		this.appoint_date = appoint_date;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getFees_collected() {
		return fees_collected;
	}

	/*
	 * @Override public String toString() { return "Appointment [appoint_id=" +
	 * appoint_id + ", date=" + date + ", doctor_id=" + doctor_id +
	 * ", patient_name=" + patient_name + ", fees_collected=" + fees_collected +
	 * "]"; }
	 */
	public void setFees_collected(String fees_collected) {
		this.fees_collected = fees_collected;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

  /*	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appoint_date=" + appoint_date + ", doctor_id=" + doctor_id
				+ ", patient_name=" + patient_name + ", fees_collected=" + fees_collected + ", doctor=" + doctor + "]";
	} */

  	@Override
	public String toString() {
		return String.format("%d,%s,%d,%s,%s", id,appoint_date,doctor_id, patient_name, fees_collected);
	} 
}
