package com.sd.hospital_management.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import com.sd.hospital_management.entity.Appointment;
import com.sd.hospital_management.entity.Insurance;
import com.sd.hospital_management.entity.Patient;
import com.sd.hospital_management.repository.InsuranceRepository;
import com.sd.hospital_management.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;
    @Transactional 
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId)
    {
        Patient patient=patientRepository.findById(patientId)
        .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }
    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);
        return patient;
    }
    
}
