package com.sd.hospital_management;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sd.hospital_management.entity.Appointment;
import com.sd.hospital_management.entity.Insurance;
import com.sd.hospital_management.entity.Patient;
import com.sd.hospital_management.service.AppintmentService;
import com.sd.hospital_management.service.InsuranceService;

@SpringBootTest 
public class InsuranceTests {
    @Autowired 
    private InsuranceService insuranceService;
    @Autowired 
    private AppintmentService appointmentService;
    @Test public void testInsurance()
    {
        Insurance insurance=Insurance.builder()
        .policyNumber("HDFC_1234")
        .provider("HDFC")
        .validUntil(LocalDate.of(2030,12,12))
        .build();
        Patient patient=insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.print(patient);
        Patient newPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);
    }
    @Test 
    public void testCreateAppointment()
    {
        Appointment appointment=Appointment.builder()
        .appointmentTime(LocalDateTime.of(2025,11,1,14,56))
        .reason("Cancer")
        .build();
        var newappontment=appointmentService.createNewAppointment(appointment,1l,2l);
        System.out.println(newappontment);
        var updatedAppointment=appointmentService.reAssignmentToAnotherDorctor(newappontment.getId(),3l);
        System.out.print(updatedAppointment);
    }
}
