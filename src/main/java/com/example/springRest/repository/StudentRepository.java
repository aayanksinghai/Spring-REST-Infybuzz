package com.example.springRest.repository;

import com.example.springRest.entity.Address;
import com.example.springRest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { // second param - datatype of ID (PK)

    List<Student>  findByFirstName(String firstname);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    List<Student> findByFirstNameIn(List<String> firstNames);

    List<Student> findByFirstNameContains(String firstName);

    List<Student> findByFirstNameStartsWith(String firstName);

    @Query("From Student where firstName = :firstName and lastName = :lastName")
    Student getByLastNameAndFirstName(String lastName, @Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query("Update Student set firstName = :firstName where id = :id")
    Integer updateFirstName(Long id, String firstName);

    @Modifying
    @Transactional
    @Query("Delete From Student where firstName = :firstName")
    Integer deleteByFirstName(String firstName);

    List<Student> findByAddressCity(String city);

    @Query("From Student where address.city = :city")
    List<Student> getByAddressCity(String city);
}
