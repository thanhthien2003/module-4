package com.example.bai_1.dto;

import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDto implements Validator {

    @NotBlank(message = "Please enter your firts name!!!")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank(message = "Please enter your firts name!!!")
    @Size(min = 5, max = 45)
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^0\\d{9}$", message = "phone number error")
    private String phoneNumber;
    @Min(value = 18, message = "Don't less than 18")
    private int age;
    @Email
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
