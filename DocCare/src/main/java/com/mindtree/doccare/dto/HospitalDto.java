package com.mindtree.doccare.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class HospitalDto {
	@Min(value = 0,message = "Hospital Revenue Cannot be Less Than Zero")
	private double hospitalRevenue;
	@NotNull(message = "hospital City Name Cannot Be null")
	
	private String hospitalCity;
	public HospitalDto() {
		// TODO Auto-generated constructor stub
	}
	public HospitalDto(double hospitalRevenue, String hospitalCity) {
		super();
		this.hospitalRevenue = hospitalRevenue;
		this.hospitalCity = hospitalCity;
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
	

}
