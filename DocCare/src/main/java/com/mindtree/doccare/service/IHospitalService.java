package com.mindtree.doccare.service;

import java.util.List;

import com.mindtree.doccare.entity.Doctor;
import com.mindtree.doccare.entity.Hospital;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;

public interface IHospitalService {
	public List<Hospital> getAllHospitalExceedingTheGivenFund(double fund) throws DocCareAppServiceException;

	public double getSumOfRevenueOfAllHospital() throws DocCareAppServiceException;

	public double getAverageOfRevenueOfAllHospital() throws DocCareAppServiceException;

	public List<Doctor> getDoctorByHospItal(int hospitalId) throws DocCareAppServiceException;

	public List<Hospital> getAllHospital() throws DocCareAppServiceException;

	public Hospital addHospital(Hospital hospital) throws DocCareAppServiceException;

	public Hospital getHospitalById(int hospitalId) throws DocCareAppServiceException;

	public Hospital updateHospital(Hospital hospital, int hospitalId) throws DocCareAppServiceException;

	public Hospital deleteHospital(int hospitalId) throws DocCareAppServiceException;

}
