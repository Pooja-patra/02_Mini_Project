package com.example.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.City;

public interface CityRepository extends JpaRepository<City,Serializable>
{
  List<City> findBystateId(Integer stateId);
}
