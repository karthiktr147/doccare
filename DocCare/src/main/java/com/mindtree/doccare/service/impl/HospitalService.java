package com.mindtree.doccare.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.mindtree.doccare.entity.Doctor;
import com.mindtree.doccare.entity.Hospital;
import com.mindtree.doccare.exception.service.DocCareAppServiceException;
import com.mindtree.doccare.exception.service.HospitalWithSuchCityNameAlreadyExist;
import com.mindtree.doccare.exception.service.NoDoctorFoundException;
import com.mindtree.doccare.exception.service.NoHospitalFoundException;
import com.mindtree.doccare.exception.service.NoHospitalWithsuchId;
import com.mindtree.doccare.repository.DoctorRepository;
import com.mindtree.doccare.repository.HospitalRepository;
import com.mindtree.doccare.service.IHospitalService;

@Service
public class HospitalService implements IHospitalService {
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public List<Hospital> getAllHospitalExceedingTheGivenFund(double fund) throws DocCareAppServiceException {
//		List<Hospital> hospitalList = hospitalRepository.findAll();
//		hospitalList.stream().findAny().orElseThrow(() -> new NoHospitalFoundException("No Hospital is Found"));
//		List<Hospital> hospitalList1 = hospitalList.stream().filter(h -> h.getHospitalRevenue() > fund)
//				.collect(Collectors.toList());
		return this.hospitalRepository.allHospitalMoreThanGivenRevenue(fund);
	}

	@Override
	public double getSumOfRevenueOfAllHospital() throws DocCareAppServiceException {
		List<Hospital> hospitalList = hospitalRepository.findAll();
		hospitalList.stream().findAny().orElseThrow(() -> new NoHospitalFoundException("No Hospital is present"));
		double sum = hospitalList.stream().map(hospital -> hospital.getHospitalRevenue()).reduce(0.0, Double::sum);
		return sum;
	}

	@Override
	public double getAverageOfRevenueOfAllHospital() throws DocCareAppServiceException {
		List<Hospital> hospitalList = hospitalRepository.findAll();
		hospitalList.stream().findAny().orElseThrow(() -> new NoHospitalFoundException("No Hospital Is Found"));
		double sum = hospitalList.stream().map(hospital -> hospital.getHospitalRevenue()).reduce(0.0, Double::sum);
		double average = sum / hospitalList.size();
		return average;
	}

	@Override
	public List<Doctor> getDoctorByHospItal(int hospitalId) throws DocCareAppServiceException {
		List<Doctor> doctorList = doctorRepository.findAll();
		doctorList.stream().findAny().orElseThrow(() -> new NoDoctorFoundException("Doctor Not Found"));
		List<Doctor> doctorList1 = doctorList.stream()
				.filter(doctor -> doctor.getHospital().getHospitalId() == hospitalId).collect(Collectors.toList());
		return doctorList1;
	}

	@Override
	public List<Hospital> getAllHospital() throws DocCareAppServiceException {
		List<Hospital> hospitalList = hospitalRepository.findAll();
		hospitalList.stream().findAny().orElseThrow(() -> new NoHospitalFoundException("No Hospital Is Present"));
		return hospitalList;
	}

	@Override
	public Hospital addHospital(Hospital hospital) throws DocCareAppServiceException {
		Hospital hospital1 = null;
		try {
			hospital1 = hospitalRepository.save(hospital);
		} catch (DataIntegrityViolationException e) {
			throw new HospitalWithSuchCityNameAlreadyExist("You can add the same city again and again");
		}
		return hospital1;
	}

	@Override
	public Hospital getHospitalById(int hospitalId) throws DocCareAppServiceException {
		Hospital hospital1 = hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new NoHospitalWithsuchId("No Hospital With Such Id to get the value"));
		return hospital1;
	}

	@Override
	public Hospital updateHospital(Hospital hospital, int hospitalId) throws DocCareAppServiceException {
		Hospital hospital1 = hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new NoHospitalWithsuchId("No Hospital with such id to update"));
		hospital1.setHospitalCity(hospital.getHospitalCity());
		hospital1.setHospitalRevenue(hospital.getHospitalRevenue());
		Hospital hospital2 = hospitalRepository.save(hospital1);
		return hospital2;
	}

	@Override
	public Hospital deleteHospital(int hospitalId) throws DocCareAppServiceException {
		Hospital hospital1 = hospitalRepository.findById(hospitalId).orElseThrow(
				() -> new NoHospitalWithsuchId("No Hospital With Such Id to delete / Data Already deleted"));
		hospitalRepository.deleteById(hospitalId);
		return hospital1;
	}

}
