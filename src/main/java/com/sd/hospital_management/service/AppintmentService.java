package com.sd.hospital_management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.hospital_management.entity.Appointment;
import com.sd.hospital_management.entity.Doctor;
import com.sd.hospital_management.entity.Patient;
import com.sd.hospital_management.repository.AppointmentRepository;
import com.sd.hospital_management.repository.DoctorRepository;
import com.sd.hospital_management.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AppintmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    @Transactional 
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId)
    {
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        if(appointment.getId()!=null )
        {
            throw new IllegalArgumentException("Appointment should not have id");
        }
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointment().add(appointment);
        return appointmentRepository.save(appointment);
    }
}

