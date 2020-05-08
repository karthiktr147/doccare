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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.doccare.dto.DoctorDto;
import com.mindtree.doccare.dto.DoctorDtoWithAge;
import com.mindtree.doccare.dto.ResponseBody;
import com.mindtree.doccare.entity.Doctor;

import com.mindtree.doccare.exception.DocCareAppException;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;
import com.mindtree.doccare.service.IDoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctrorController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	IDoctorService doctorService;

	@GetMapping(path = "/getAllDoctorWithoutAge")
	public ResponseEntity<?> getAllDoctorWithoutAge(int hospitalId) throws DocCareAppException {
		return new ResponseEntity<ResponseBody<List<DoctorDto>>>(new ResponseBody<List<DoctorDto>>(
				doctorService.getAllDoctorWithoutAge(hospitalId), null, "success", true), HttpStatus.OK);
	}

	@GetMapping(path = "/getAllDoctorAgeGreaterThanForty()")
	public ResponseEntity<?> getAllDoctorAgeGreaterThanForty() throws DocCareAppException {
		return new ResponseEntity<ResponseBody<List<Doctor>>>(
				new ResponseBody<List<Doctor>>(doctorService.getAllDoctorAgeGreaterThanForty(), null, "success", true),
				HttpStatus.OK);
	}

	@PostMapping(path = "/addDoctor")
	public ResponseEntity<?> addDoctor(@Valid @RequestBody DoctorDtoWithAge doctor) throws DocCareAppException {
		return new ResponseEntity<ResponseBody<Doctor>>(new ResponseBody<Doctor>(
				doctorService.addDoctor(modelMapper.map(doctor, Doctor.class)), null, "success", true), HttpStatus.OK);
	}

	@GetMapping(path = "/getDoctorById")
	public ResponseEntity<?> getDoctorById(int doctorId) throws DocCareAppException {
		return new ResponseEntity<ResponseBody<Doctor>>(
				new ResponseBody<Doctor>(doctorService.getDoctorById(doctorId), null, "success", true), HttpStatus.OK);
	}

	@PutMapping(path = "/updateDoctor", name = "update Doctor")
	public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor, @RequestParam int doctorId)
			throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Doctor>>(
				new ResponseBody<Doctor>(doctorService.updateDoctor(doctor, doctorId), null, "success", true),
				HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteDoctor/{doctorId}")
	public ResponseEntity<?> deleteDoctor(@PathVariable int doctorId) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Doctor>>(
				new ResponseBody<Doctor>(doctorService.deleteDoctor(doctorId), null, "success", true), HttpStatus.OK);
	}

}
