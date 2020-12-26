package com.example.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Country;

public interface CountryRepository extends JpaRepository<Country,Serializable> {

}
