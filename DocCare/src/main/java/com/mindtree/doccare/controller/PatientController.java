package com.mindtree.doccare.controller;

import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.doccare.dto.PatientDto;
import com.mindtree.doccare.dto.PatientDtoWithoutAge;
import com.mindtree.doccare.dto.ResponseBody;
import com.mindtree.doccare.entity.Hospital;
import com.mindtree.doccare.entity.Patient;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;
import com.mindtree.doccare.service.IPatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private IPatientService patientService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping(path = "/addPatient/{hospitalId}")
	public ResponseEntity<?> addPatient(@Valid PatientDto patient, @PathVariable int hospitalId)
			throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Patient>>(new ResponseBody<Patient>(
				patientService.addPatient(modelMapper.map(patient, Patient.class), hospitalId), null, "success", true),
				HttpStatus.OK);
	}

	@GetMapping(path = "/getPatientByHospital/{hospitalId}")
	public ResponseEntity<?> getPatientByHospital(@PathVariable int hospitalId) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<List<Patient>>>(
				new ResponseBody<List<Patient>>(patientService.getPatientByHospital(hospitalId), null, "success", true),
				HttpStatus.OK);
	}

	@GetMapping(path = "/getHospitalIfTwoPatientsInIcu")
	public ResponseEntity<?> getHospitalIfTwoPatientsInIcu() throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<List<Hospital>>>(
				new ResponseBody<List<Hospital>>(patientService.getHospitalIfTwoPatientsInIcu(), null, "success", true),
				HttpStatus.OK);

	}

	@GetMapping(path = "/getHospitalIfTwoPatientsInIcuAndAgeGreaterThanForty")
	public ResponseEntity<?> getHospitalIfTwoPatientsInIcuAndAgeGreaterThanForty() throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<List<Hospital>>>(
				new ResponseBody<List<Hospital>>(patientService.getHospitalIfTwoPatientsInIcuAndAgeGreaterThanForty(),
						null, "success", true),
				HttpStatus.OK);

	}

	@GetMapping(path = "/getPatientsReleased")
	public ResponseEntity<?> getPatientsReleased() throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<List<Patient>>>(
				new ResponseBody<List<Patient>>(patientService.getPatientsReleased(), null, "success", true),
				HttpStatus.OK);
	}

	@GetMapping(path = "/getPatientExcludingAgeByHospital")
	public ResponseEntity<?> getPatientExcludingAgeByHospital(int hospitalId) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<List<PatientDtoWithoutAge>>>(
				new ResponseBody<List<PatientDtoWithoutAge>>(
						patientService.getPatientExcludingAgeByHospital(hospitalId), null, "success", true),
				HttpStatus.OK);
	}

	@GetMapping(path = "/getAllPatient")
	public ResponseEntity<?> getAllPatient() throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<List<Patient>>>(
				new ResponseBody<List<Patient>>(patientService.getAllPatient(), null, "success", true), HttpStatus.OK);
	}

	@PutMapping(path = "/updatePatient")
	public ResponseEntity<?> updatePatient(@Valid PatientDto patient, int patientId) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Patient>>(new ResponseBody<Patient>(
				patientService.updatePatient(modelMapper.map(patient, Patient.class), patientId), null, "success",
				true), HttpStatus.OK);
	}

	@DeleteMapping(path = "/deletePatient")
	public ResponseEntity<?> deletePatient(int patientId) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Patient>>(
				new ResponseBody<Patient>(patientService.deletePatient(patientId), null, "success", true),
				HttpStatus.OK);
	}
}
