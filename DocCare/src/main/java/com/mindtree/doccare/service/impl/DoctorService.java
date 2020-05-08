package com.mindtree.doccare.service.impl;

import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.doccare.dto.DoctorDto;
import com.mindtree.doccare.entity.Doctor;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;
import com.mindtree.doccare.exception.service.NoDoctorFoundException;
import com.mindtree.doccare.exception.service.NoDoctorWithSuchId;
import com.mindtree.doccare.repository.DoctorRepository;
import com.mindtree.doccare.service.IDoctorService;

@Service
public class DoctorService implements IDoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getAllDoctorAgeGreaterThanForty() throws DocCareAppServiceException {
		List<Doctor> doctorList = doctorRepository.findAll();
		doctorList.stream().findAny().orElseThrow(() -> new NoDoctorFoundException("No Doctor Is Found"));
		List<Doctor> doctorList1 = doctorList.stream().filter(doctor -> doctor.getAge() > 40)
				.collect(Collectors.toList());
		return doctorList1;
	}

	@Override
	public List<DoctorDto> getAllDoctorWithoutAge(int hospitalId) throws NoDoctorFoundException {
		List<Doctor> doctorList = doctorRepository.findAll();
		doctorList.stream().findAny().orElseThrow(() -> new NoDoctorFoundException("No Doctor Is Found"));
		List<DoctorDto> doctorList1 = doctorList.stream()
				.filter(doctor -> doctor.getHospital().getHospitalId() == hospitalId).map(doctor -> doctorDto(doctor))
				.collect(Collectors.toList());
		return doctorList1;
	}

	public DoctorDto doctorDto(Doctor doctor) {
		DoctorDto doctorDto = new DoctorDto();
		doctorDto.setDocterId(doctor.getDocterId());
		doctorDto.setDoctorName(doctor.getDoctorName());
		return doctorDto;

	}

	@Override
	public Doctor addDoctor(Doctor doctor) throws DocCareAppServiceException {
		Doctor doctor1 = doctorRepository.save(doctor);
		return doctor1;
	}

	@Override
	public Doctor getDoctorById(int doctorId) throws DocCareAppServiceException {
		Doctor doctor1 = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new NoDoctorWithSuchId("No Doctor With Such Id"));
		return doctor1;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, int doctorId) throws DocCareAppServiceException {
		Doctor doctor1 = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new NoDoctorWithSuchId("No Doctor With Such Id to update"));
		doctor1.setAge(doctor.getAge());
		doctor1.setDoctorName(doctor.getDoctorName());
		Doctor doctor2 = doctorRepository.save(doctor1);
		return doctor2;
	}

	@Override
	public Doctor deleteDoctor(int doctorId) throws DocCareAppServiceException {
		Doctor doctor1 = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new NoDoctorWithSuchId("No Doctor With Such Id to delete / Data Already Deleted"));
		doctorRepository.deleteById(doctorId);
		return doctor1;
	}

}
