package com.mindtree.doccare.dto;
public class DoctorDto {
	private int docterId;
	private String doctorName;
	public DoctorDto() {
		// TODO Auto-generated constructor stub
	}
	public DoctorDto(int docterId, String doctorName) {
		super();
		this.docterId = docterId;
		this.doctorName = doctorName;
	}
	public int getDocterId() {
		return docterId;
	}
	public void setDocterId(int docterId) {
		this.docterId = docterId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	

}
