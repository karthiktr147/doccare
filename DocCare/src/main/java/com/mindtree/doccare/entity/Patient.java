package com.mindtree.doccare.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patientId")
	private int patientId;
	@Column(name = "patientAddress", nullable = false)
	private String patientAddress;
	@Column(name = "patientName", nullable = false)
	private String patientName;
	@Column(name = "patientAge", nullable = false)
	private int patientAge;
	@Column(name = "patientIcuStatus", nullable = false)
	private IcuStatus icuStatus;
	@Column(name = "patientStatus", nullable = false)
	private AdmissionStatus status;
	@JsonIgnore
	@NotNull
	@ManyToOne
	private Hospital hospital;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int patientId, String patientAddress, String patientName, int patientAge, AdmissionStatus status,
			@NotNull Hospital hospital) {
		super();
		this.patientId = patientId;
		this.patientAddress = patientAddress;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.status = status;
		this.hospital = hospital;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public AdmissionStatus getStatus() {
		return status;
	}
	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Patient(int patientId, String patientAddress, String patientName, int patientAge, IcuStatus icuStatus,
			AdmissionStatus status, @NotNull Hospital hospital) {
		super();
		this.patientId = patientId;
		this.patientAddress = patientAddress;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.icuStatus = icuStatus;
		this.status = status;
		this.hospital = hospital;
	}
	public IcuStatus getIcuStatus() {
		return icuStatus;
	}
	public void setIcuStatus(IcuStatus icuStatus) {
		this.icuStatus = icuStatus;
	}
	
}
