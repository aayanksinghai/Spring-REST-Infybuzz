package com.example.springRest.repository;

import com.example.springRest.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

        }
