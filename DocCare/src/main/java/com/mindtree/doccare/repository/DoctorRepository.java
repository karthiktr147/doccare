package com.mindtree.doccare.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mindtree.doccare.entity.Doctor;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Integer>{

}
