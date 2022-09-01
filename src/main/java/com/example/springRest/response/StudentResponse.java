package com.example.springRest.response;

import com.example.springRest.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentResponse {
    @JsonProperty("id")
    private long id;
    @JsonProperty("first_name")
    private String firstName;

   @JsonProperty("last_name")
    private String lastName;

   @JsonProperty("email")
    private String email;


   @JsonProperty("fullName")
   private String fullName;

    public String getStreet() {
        return street;
    }

    public StudentResponse(String street, String city) {
        this.street = street;
        this.city = city;
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

    private String street;
   private String city;


    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.fullName = student.getFirstName() + " " + student.getLastName();

        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


}
