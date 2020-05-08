package com.mindtree.doccare.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.doccare.dto.PatientDtoWithoutAge;
import com.mindtree.doccare.entity.Hospital;
import com.mindtree.doccare.entity.Patient;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;
import com.mindtree.doccare.exception.service.NoDoctorFoundException;
import com.mindtree.doccare.exception.service.NoHospitalFoundException;
import com.mindtree.doccare.exception.service.NoHospitalWithSuchCondition;
import com.mindtree.doccare.exception.service.NoPatientFoundException;
import com.mindtree.doccare.repository.HospitalRepository;
import com.mindtree.doccare.repository.PatientRepository;
import com.mindtree.doccare.service.IPatientService;

@Service
public class PatientService implements IPatientService {
	@Autowired
	private HospitalRepository hospitalRepository;
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient, int hospitalId) throws DocCareAppServiceException {
		hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new NoHospitalFoundException("No Hospital with such id found"));
		patientRepository.save(patient);
		return patient;
	}

	@Override
	public List<Patient> getPatientByHospital(int hospitalId) throws DocCareAppServiceException {
		List<Patient> patientList = patientRepository.findAll();
		patientList.stream().findAny().orElseThrow(() -> new NoPatientFoundException("No Patient Found"));
		List<Patient> patientList1 = patientList.stream()
				.filter(patient -> patient.getHospital().getHospitalId() == hospitalId).collect(Collectors.toList());
		return patientList1;
	}

	@Override
	public List<Hospital> getHospitalIfTwoPatientsInIcu() throws DocCareAppServiceException {
		List<Patient> patientList = patientRepository.findAll();
		patientList.stream().findAny().orElseThrow(() -> new NoPatientFoundException("No Patient Found"));
		List<Hospital> hospitalList = patientList.stream()
				.filter(patient -> patient.getIcuStatus().toString().compareTo("icu") == 0)
				.map(patient -> patient.getHospital()).collect(Collectors.toList());
		if(hospitalList.size()>=2)
		throw new NoHospitalWithSuchCondition("no hospitals with given condition");
		else
		return hospitalList;
	}

	@Override
	public List<Hospital> getHospitalIfTwoPatientsInIcuAndAgeGreaterThanForty() throws DocCareAppServiceException {
		List<Patient> patientList = patientRepository.findAll();
		patientList.stream().findAny().orElseThrow(() -> new NoPatientFoundException("No Patient Found"));
		List<Hospital> hospitalList = patientList.stream().filter(
				patient -> ((patient.getIcuStatus().toString().equals("icu")) && (patient.getPatientAge() > 40)))
				.map(patient -> patient.getHospital()).collect(Collectors.toList());
		return hospitalList;
	}

	@Override
	public List<Patient> getPatientsReleased() throws DocCareAppServiceException {
		List<Patient> patientList = patientRepository.findAll();
		patientList.stream().findAny().orElseThrow(() -> new NoPatientFoundException("No Patient Found"));
		List<Patient> patientList1 = patientList.stream()
				.filter(patient -> patient.getStatus().toString().compareTo("notAdmitted") == 0)
				.collect(Collectors.toList());
		return patientList1;
	}

	@Override
	public List<PatientDtoWithoutAge> getPatientExcludingAgeByHospital(int hospitalId)
			throws DocCareAppServiceException {
		List<Patient> patientList = patientRepository.findAll();
		patientList.stream().findAny().orElseThrow(() -> new NoDoctorFoundException("No Doctor Is Found"));
		List<PatientDtoWithoutAge> patientList1 = patientList.stream()
				.filter(patient -> patient.getHospital().getHospitalId() == hospitalId)
				.map(patient -> patientDto(patient)).collect(Collectors.toList());
		return patientList1;
	}

	public PatientDtoWithoutAge patientDto(Patient patient) {
		PatientDtoWithoutAge patientDto = new PatientDtoWithoutAge();
		patientDto.setHospital(patient.getHospital());
		patientDto.setIcuStatus(patient.getIcuStatus());
		patientDto.setPatientAddress(patient.getPatientAddress());
		patientDto.setPatientName(patient.getPatientName());
		patientDto.setStatus(patient.getStatus());
		return patientDto;
	}

	@Override
	public List<Patient> getAllPatient() throws DocCareAppServiceException {
		List<Patient> patientList = patientRepository.findAll();
		patientList.stream().findAny()
				.orElseThrow(() -> new NoPatientFoundException("No Patient Found to get the patient"));
		return patientList;
	}

	@Override
	public Patient updatePatient(Patient patient, int patientId) throws DocCareAppServiceException {
		Patient patient1 = patientRepository.findById(patientId)
				.orElseThrow(() -> new NoPatientFoundException("No patient with such Id to update"));
		patient1.setIcuStatus(patient.getIcuStatus());
		patient1.setPatientAddress(patient.getPatientAddress());
		patient1.setPatientAge(patient.getPatientAge());
		patient1.setPatientName(patient.getPatientName());
		patient1.setStatus(patient.getStatus());
		patientRepository.save(patient1);
		return patient1;
	}

	@Override
	public Patient deletePatient(int patientId) throws DocCareAppServiceException {
		Patient patient = patientRepository.findById(patientId).orElseThrow(
				() -> new NoPatientFoundException("No patient with such Id to Delete/Data Already Deleted"));
		patientRepository.deleteById(patientId);
		return patient;
	}

}
