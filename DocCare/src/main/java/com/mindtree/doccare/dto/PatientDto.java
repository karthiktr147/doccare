package com.mindtree.doccare.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.mindtree.doccare.entity.AdmissionStatus;
import com.mindtree.doccare.entity.IcuStatus;

public class PatientDto {
	@NotNull
	private String patientAddress;
	@NotNull
	@Length(min = 3,max = 15,message = "name length should be between three and fifteen")
	private String patientName;
	@Min(value = 0,message = "age cannot be negative")
	@Max(value = 130,message = "age cannot be greater than 130")
	private  int patientAge;
	@NotNull
	private  IcuStatus icuStatus;
	@NotNull
	private AdmissionStatus status;
	@NotNull(message = "hospital name cannot be null")
	private int hospitalId;
	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDto(@NotNull String patientAddress,
			@NotNull @Length(min = 3, max = 15, message = "name length should be between three and fifteen") String patientName,
			@Min(value = 0, message = "age cannot be negative") @Max(value = 130, message = "age cannot be greater than 130") int patientAge,
			@NotNull IcuStatus icuStatus, @NotNull AdmissionStatus status,
			@NotNull(message = "hospital name cannot be null") int hospitalId) {
		super();
		this.patientAddress = patientAddress;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.icuStatus = icuStatus;
		this.status = status;
		this.hospitalId = hospitalId;
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
	public IcuStatus getIcuStatus() {
		return icuStatus;
	}
	public void setIcuStatus(IcuStatus icuStatus) {
		this.icuStatus = icuStatus;
	}
	public AdmissionStatus getStatus() {
		return status;
	}
	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	
}
