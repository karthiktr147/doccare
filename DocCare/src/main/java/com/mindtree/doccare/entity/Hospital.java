package com.mindtree.doccare.entity;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "hospitals")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hospitalId")
	private int hospitalId;
	@Column(name = "hospitalRevenue", nullable = false)
	private double hospitalRevenue;
	@Column(name = "hospitalCity", nullable = false, unique = true)
	private String hospitalCity;
	@JsonIgnore
	@ElementCollection
    @CollectionTable(name = "doctorList", joinColumns = @JoinColumn(name = "hospital"))
	private List<Doctor> doctorSet;
	@JsonIgnore
	@ElementCollection
    @CollectionTable(name = "patientList", joinColumns = @JoinColumn(name = "hospital"))
	private List<Patient> patientSet;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int hospitalId, double hospitalRevenue, String hospitalCity, List<Doctor> doctorSet) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalRevenue = hospitalRevenue;
		this.hospitalCity = hospitalCity;
		this.doctorSet = doctorSet;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public double getHospitalRevenue() {
		return hospitalRevenue;
	}

	public void setHospitalRevenue(double hospitalRevenue) {
		this.hospitalRevenue = hospitalRevenue;
	}

	public String getHospitalCity() {
		return hospitalCity;
	}

	public void setHospitalCity(String hospitalCity) {
		this.hospitalCity = hospitalCity;
	}

	public List<Doctor> getDoctorSet() {
		return doctorSet;
	}

	public void setDoctorSet(List<Doctor> doctorSet) {
		this.doctorSet = doctorSet;
	}

}
