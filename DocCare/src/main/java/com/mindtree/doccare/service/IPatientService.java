package com.mindtree.doccare.service;

import java.util.List;
import com.mindtree.doccare.dto.PatientDtoWithoutAge;
import com.mindtree.doccare.entity.Hospital;
import com.mindtree.doccare.entity.Patient;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;

public interface IPatientService {
	public Patient addPatient(Patient patient, int hospitalId) throws DocCareAppServiceException;

	public List<Patient> getPatientByHospital(int hospitalId) throws DocCareAppServiceException;

	public List<Hospital> getHospitalIfTwoPatientsInIcu() throws DocCareAppServiceException;

	public List<Hospital> getHospitalIfTwoPatientsInIcuAndAgeGreaterThanForty() throws DocCareAppServiceException;

	public List<Patient> getPatientsReleased() throws DocCareAppServiceException;

	public List<PatientDtoWithoutAge> getPatientExcludingAgeByHospital(int hospitalId) throws DocCareAppServiceException;

	public List<Patient> getAllPatient() throws DocCareAppServiceException;
	
	public Patient updatePatient(Patient patient,int patientId) throws DocCareAppServiceException;
	
	public Patient deletePatient(int patientId) throws DocCareAppServiceException;
}
