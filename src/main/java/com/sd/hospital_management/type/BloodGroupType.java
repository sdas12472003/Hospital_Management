package com.sd.hospital_management.type;

public enum BloodGroupType {
 
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String value;

    BloodGroupType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
