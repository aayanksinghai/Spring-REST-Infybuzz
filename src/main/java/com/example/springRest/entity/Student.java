package com.example.springRest.entity;


import com.example.springRest.request.CreateStudentRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //    Default constructor for entity class is a must
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // used for auto increment
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;


    @OneToMany(mappedBy = "student")
    private List<Subject> learningSubjects;

    @Transient
    private String fullName; // this field is not representing the data member req for mapping in dbms

    public Student(){}
    public Student(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fullName = firstName + " " + lastName;
    }

    public Student(CreateStudentRequest createStudentRequest){
        // this.id = createStudentRequest.getId();
        this.firstName = createStudentRequest.getFirstName();
        this.lastName = createStudentRequest.getLastName();
        this.email = createStudentRequest.getEmail();
        this.fullName = createStudentRequest.getFirstName() + " " + createStudentRequest.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public void setLearningSubjects(List<Subject> subjectList) {
    }
}
