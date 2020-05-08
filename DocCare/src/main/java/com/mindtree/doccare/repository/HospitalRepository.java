package com.mindtree.doccare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.doccare.entity.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	@Query(value = "Select h FROM Hospital h WHERE h.hospitalRevenue>?1")
	List<Hospital> allHospitalMoreThanGivenRevenue(double revenue);
}
