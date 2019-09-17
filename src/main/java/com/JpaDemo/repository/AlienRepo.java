package com.JpaDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JpaDemo.model.Alien;



public interface AlienRepo extends JpaRepository<Alien, Integer> 
{
	List<Alien> findByAidGreaterThan(int aid);
}
