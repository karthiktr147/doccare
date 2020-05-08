package com.mindtree.doccare.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.doccare.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
}
