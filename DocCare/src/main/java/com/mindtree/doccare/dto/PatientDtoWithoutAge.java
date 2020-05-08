package com.mindtree.doccare.dto;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.mindtree.doccare.entity.AdmissionStatus;
import com.mindtree.doccare.entity.Hospital;
import com.mindtree.doccare.entity.IcuStatus;

public class PatientDtoWithoutAge {
	@NotNull
	private String patientAddress;
	@NotNull
	@Length(min = 3,max = 15,message = "name length should be between three and fifteen")
	private String patientName;
	@NotNull
	private  IcuStatus icuStatus;
	@NotNull
	private AdmissionStatus status;
	@NotNull(message = "hospital name cannot be null")
	private Hospital hospital;
	public PatientDtoWithoutAge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDtoWithoutAge(@NotNull String patientAddress,
			@NotNull @Length(min = 3, max = 15, message = "name length should be between three and fifteen") String patientName,
			@NotNull IcuStatus icuStatus, @NotNull AdmissionStatus status,
			@NotNull(message = "hospital name cannot be null") Hospital hospital) {
		super();
		this.patientAddress = patientAddress;
		this.patientName = patientName;
		this.icuStatus = icuStatus;
		this.status = status;
		this.hospital = hospital;
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
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	

}
