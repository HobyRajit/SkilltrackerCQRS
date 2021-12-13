package com.skilltracker.engineer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skilltracker.engineer.entity.Profile;
import com.skilltracker.engineer.entity.Skill;
import com.skilltracker.engineer.repository.ProfileRepository;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@PostMapping("/add/profile")
	public Profile saveProfile(@RequestBody Profile profile)
	{
		return profileRepository.saveProfile(profile);
	}
		
	@GetMapping("/get/profile/{id}")
	public Profile getProfileById(@PathVariable("id") String associateId){
		return profileRepository.getProfileById(associateId);
	}
	
	@DeleteMapping("delete/profile/{id}")
	public String deleteProfileById(@PathVariable("id") String associateId) {
		return profileRepository.deleteProfileById(associateId);
	}
	
	@PutMapping("/update/profile/{id}")
	public String updateProfile(@PathVariable("id") String associateId,@RequestBody Skill skill) {
		
		return profileRepository.saveSkill(associateId, skill); 
		
	}
	
	@PutMapping("/update/skill/{id}")
	public String updateSkill(@PathVariable("id") String associateId,@RequestBody Skill skill) {
		return profileRepository.updateSkill(associateId,skill);
	}

}
