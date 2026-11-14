package com.sd.hospital_management.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.sd.hospital_management.type.BloodGroupType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 
@ToString 
@Setter 
@Getter 
@Table(name="patient", // It is used to specify the name of the table in the database that this entity will be mapped to. If not specified, the default table name will be the same as the entity class name.
    uniqueConstraints={
        //@UniqueConstraint(name="unique_patient_email", columnNames={"email"}),
        @UniqueConstraint(name="unique_patient_name_dob", columnNames={"name", "dateOfBirth"})
    }, // uniqueConstraints is used to specify unique constraints on the table. In this case, it is empty, meaning there are no unique constraints defined for this table. as an example that for same email , if two data is inserted then it will throw an error because email is unique for each patient.
    indexes = {
        @Index(name="idx_patient_birth_date", columnList="dateOfBirth")
    }
)
public class Patient {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(//name="patient_name", 
    nullable=false,length=100) // it is used to specify the name of the column in the database that this field will be mapped to. If not specified, the default column name will be the same as the field name. and nullable=false means that this column cannot be null in the database, meaning that a value must be provided for this field when creating or updating a Patient entity. length is used to specify the maximum length of the column in the database. In this case, it is set to 100 characters.
    private String name;
    //@ToString.Exclude
    private LocalDate dateOfBirth;
    private String gender;
    @Column (name="email", unique=true, nullable=false)// It is used to specify the name of the column in the database that this field will be mapped to. If not specified, the default column name will be the same as the field name. It is also used to specify that this column should have a unique constraint, meaning that no two rows in the table can have the same value for this column.
    private String email;
    @CreationTimestamp // It is used to automatically populate the createdAt field with the current timestamp when a new Patient entity is created and persisted to the database. This annotation is provided by Hibernate, which is the underlying JPA implementation used by Spring Boot.
    @Column (updatable=false) // It is used to specify that this column should not be updated after the entity is created. This means that once the createdAt field is set when the entity is first persisted, it cannot be changed or updated later.
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING) // It is used to specify that the bloodGroup field should be persisted as a string representation of the BloodGroupType enum values in the database. This means that when a Patient entity is saved to the database, the bloodGroup field will be stored as a string (e.g., "A+", "B-", etc.) rather than as an ordinal value (0, 1, 2, etc.) corresponding to the position of the enum constants.
    private BloodGroupType bloodGroup;
    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval=true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;
   @OneToMany(
    mappedBy = "patient",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY
)
@ToString.Exclude
private List<Appointment> appointments = new ArrayList<>();
    
}

