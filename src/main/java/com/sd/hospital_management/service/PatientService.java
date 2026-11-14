package com.sd.hospital_management.service;

import org.springframework.stereotype.Service;

import com.sd.hospital_management.entity.Patient;
import com.sd.hospital_management.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class PatientService {
    private final PatientRepository patientRepository;
    @Transactional 
    public Patient getPatientById(Long id) {
        Patient p1= patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        Patient p2= patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        System.out.println(p1==p2);
        p1.setName("John Doe");
        return p1;
    }
}
