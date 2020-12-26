package com.example.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.State;

public interface StateRepository extends JpaRepository<State,Serializable>
{
	List<State> findBycountryId(Integer countryId);

}
