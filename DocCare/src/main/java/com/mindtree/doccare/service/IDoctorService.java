package com.mindtree.doccare.service;

import java.util.List;

import com.mindtree.doccare.dto.DoctorDto;
import com.mindtree.doccare.entity.Doctor;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;

public interface IDoctorService {
	public List<DoctorDto> getAllDoctorWithoutAge(int hospitalId) throws DocCareAppServiceException;

	public List<Doctor> getAllDoctorAgeGreaterThanForty() throws DocCareAppServiceException;

	public Doctor addDoctor(Doctor doctor) throws DocCareAppServiceException;

	public Doctor getDoctorById(int doctorId) throws DocCareAppServiceException;

	public Doctor updateDoctor(Doctor doctor, int doctorId) throws DocCareAppServiceException;

	public Doctor deleteDoctor(int doctorId) throws DocCareAppServiceException;
}
