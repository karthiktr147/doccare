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
import com.mindtree.doccare.dto.HospitalDto;
import com.mindtree.doccare.dto.ResponseBody;
import com.mindtree.doccare.entity.Doctor;
import com.mindtree.doccare.entity.Hospital;
import com.mindtree.doccare.exception.DocCareAppException;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;
import com.mindtree.doccare.service.IHospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	IHospitalService hospitalService;

	@GetMapping(path = "/getAllHospitalExceedingTheGivenFund")
	public ResponseEntity<?> getAllHospitalExceedingTheGivenFund(@RequestParam double fund) throws DocCareAppException {
		return new ResponseEntity<ResponseBody<List<Hospital>>>(new ResponseBody<List<Hospital>>(
				hospitalService.getAllHospitalExceedingTheGivenFund(fund), null, "success", true), HttpStatus.OK);
	}

	@GetMapping(path = "/getSumOfRevenueOfAllHospital")
	public ResponseEntity<?> getSumOfRevenueOfAllHospital() throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Double>>(
				new ResponseBody<Double>(hospitalService.getSumOfRevenueOfAllHospital(), null, "success", true),
				HttpStatus.OK);
	}

	@GetMapping(path = "/getAverageOfRevenueOfAllHospital")
	public ResponseEntity<?> getAverageOfRevenueOfAllHospital() throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Double>>(
				new ResponseBody<Double>(hospitalService.getAverageOfRevenueOfAllHospital(), null, "success", true),
				HttpStatus.OK);
	}

	@GetMapping(path = "/getDoctorByHospItal")
	public ResponseEntity<?> getDoctorByHospItal(@RequestParam int hospitalId) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<List<Doctor>>>(
				new ResponseBody<List<Doctor>>(hospitalService.getDoctorByHospItal(hospitalId), null, "success", true),
				HttpStatus.OK);
	}

	@GetMapping(path = "/getAllHospital")
	public ResponseEntity<?> getAllHospital() throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<List<Hospital>>>(
				new ResponseBody<List<Hospital>>(hospitalService.getAllHospital(), null, "success", true),
				HttpStatus.OK);
	}

	@PostMapping(path = "/addHospital")
	public ResponseEntity<?> addHospital(@Valid @RequestBody HospitalDto hospital) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Hospital>>(
				new ResponseBody<Hospital>(hospitalService.addHospital(modelMapper.map(hospital, Hospital.class)), null,
						"success", true),
				HttpStatus.CREATED);
	}

	@GetMapping(path = "/getHospitalById")
	public ResponseEntity<?> getHospitalById(@RequestParam int hospitalId) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Hospital>>(
				new ResponseBody<Hospital>(hospitalService.getHospitalById(hospitalId), null, "success", true),
				HttpStatus.OK);
	}

	@PutMapping(path = "/updateHospital")
	public ResponseEntity<?> updateHospital(@Valid @RequestBody HospitalDto hospital, @RequestParam int hospitalId)
			throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Hospital>>(new ResponseBody<Hospital>(
				hospitalService.updateHospital(modelMapper.map(hospital, Hospital.class), hospitalId), null, "success",
				true), HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteHospital/{hospitalId}")
	public ResponseEntity<?> deleteHospital(@PathVariable int hospitalId) throws DocCareAppServiceException {
		return new ResponseEntity<ResponseBody<Hospital>>(
				new ResponseBody<Hospital>(hospitalService.deleteHospital(hospitalId), null, "success", true),
				HttpStatus.OK);
	}
}
