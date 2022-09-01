package com.example.springRest.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CreateStudentRequest {

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

//
//    private Long id;
    @JsonProperty("first_name")
    @NotBlank(message = "First name is required")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    private String street;
    private String city;

    private List<CreateSubjectRequest> subjectsLearning;

    public List<CreateSubjectRequest> getSubjectsLearning() {
        return subjectsLearning;
    }

    public void setSubjectsLearning(List<CreateSubjectRequest> subjectsLearning) {
        this.subjectsLearning = subjectsLearning;
    }

    public String getStreet() {
        return street;
    }

    public CreateStudentRequest(String firstName, String lastName, String street, String city, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.email = email;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}
