package com.mindtree.doccare.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.mindtree.doccare.entity.Hospital;
public class DoctorDtoWithAge {
	@NotNull(message = "doctor name cannot be null")
	private String doctorName;
	@Min(value = 25,message = "Doctor Age Cannot be Less than 25")
	@Max(value = 70,message = "Doctor Age Cannot be greater than 70")
	private int doctorAge;
	@NotNull(message = "hospital name cannot be null")
	private Hospital hospital;
	public DoctorDtoWithAge() {
	}
	public DoctorDtoWithAge(@NotNull(message = "doctor name cannot be null") String doctorName,
			@Min(value = 25, message = "Doctor Age Cannot be Less than 25") @Max(value = 70, message = "Doctor Age Cannot be greater than 70") int doctorAge,
			@NotNull(message = "hospital name cannot be null") Hospital hospital) {
		super();
		this.doctorName = doctorName;
		this.doctorAge = doctorAge;
		this.hospital = hospital;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDoctorAge() {
		return doctorAge;
	}
	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	

}
