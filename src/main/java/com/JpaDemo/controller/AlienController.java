package com.JpaDemo.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.JpaDemo.model.Alien;
import com.JpaDemo.repository.AlienRepo;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		return alien;
		
	}
	
	@RequestMapping(path = "/aliens" )
	public List<Alien> getAliens() {
		
		return repo.findAll();
	
	}
	
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return  repo.findById(aid);
		
	}

	@DeleteMapping ("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid){

	    Alien a = repo.getOne(aid);

	    repo.delete(a);
	    return "Deleted";

    }

    @PutMapping ("/alien")
    public Alien saveOrUpdateAlien(@RequestBody Alien alien) {

        repo.save(alien);
        return alien;

    }

}
