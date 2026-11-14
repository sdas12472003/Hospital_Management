package com.sd.hospital_management;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.sd.hospital_management.dto.BloodGroupCountResponseEntity;
import com.sd.hospital_management.entity.Patient;
import com.sd.hospital_management.repository.PatientRepository;
import com.sd.hospital_management.service.PatientService;
import com.sd.hospital_management.type.BloodGroupType;

@SpringBootTest 
public class PatientTests {
    @Autowired 
    private PatientRepository patientRepository;
    @Autowired 
    private PatientService patientService;
    @Test 
    public void testPatientRepository()
    {
        List<Patient> patients = patientRepository.findAllPatientWithAppointment();
        System.out.println("Number of patients: " + patients);

        Patient patient = new Patient();
        patientRepository.save(patient);
    }
    @Test 
    public void testTransactioanlMethods()
    {
    //    Patient patient=patientService.getPatientById(1L);
        //Patient patient=patientRepository.findByName("John Doe");
        //List<Patient> patient=patientRepository.findByDateOfBirthOrEmail(java.time.LocalDate.of(2000, 05, 15), "priya@gmail.com");
        // List<Patient> patient=patientRepository.findByNameContaining("Jo");
        // List<Patient> patient=patientRepository.findByNameContainingOrderByIdDesc("Jo");
        //List<Patient> patient=patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE.name());
        // List<Patient> patient=patientRepository.findByBornAfterDate(java.time.LocalDate.of(2000, 05, 15));
        // for(Patient p:patient)
        // {
        //     System.out.println("Patient: " + p);
        // }
        // List<Object[]> bloodGroupCounts = patientRepository.countPatientsByBloodGroup();
        // for (Object[] row : bloodGroupCounts) {
        //     String bloodGroup = (String) row[0];
        //     Long count = (Long) row[1];
        //     System.out.println("Blood Group: " + bloodGroup + ", Count: " + count);
        // }
        // List<Patient> patientList=patientRepository.findAllPatients();
        // int rowsUpdated=patientRepository.updateNameWithId("Shuvam Das", 1L);
        // System.out.println("Number of rows updated: " + rowsUpdated);
        // List<BloodGroupCountResponseEntity> bloodGroupCounts = patientRepository.countPatientsByBloodGroupType();
        // for (BloodGroupCountResponseEntity entity : bloodGroupCounts) {
        //     System.out.println("Blood Group: " + entity.getBloodGroupType() + ", Count: " + entity.getCount());
        // }
        List<Patient> patients = patientRepository.findAllPatients(PageRequest.of(0, 5)); // Fetch the first page with 5 patients per page
        for (Patient p : patients) {
            System.out.println("Patient: " + p);
        }
    }
}
