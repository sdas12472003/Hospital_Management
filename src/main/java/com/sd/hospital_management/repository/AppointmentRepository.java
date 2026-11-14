package com.sd.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.hospital_management.entity.Appointment;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long>{

}
