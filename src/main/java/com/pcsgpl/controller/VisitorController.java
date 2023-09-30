package com.pcsgpl.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcsgpl.entity.Visitor;
import com.pcsgpl.exception.ResourceNotFoundException;
import com.pcsgpl.repository.VisitorRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/visit")
public class VisitorController {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	//get all visitor
	@GetMapping("/visitor")
	public List <Visitor> getAllVisitor() {	
		return visitorRepository.findAll();
	}
	//get visitor by id
	@GetMapping("/visitor/{id}")
	public ResponseEntity<Visitor> getVisitorById(@PathVariable int id){
		Visitor visitor = visitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Visitor not exist with id:" +id));
				return ResponseEntity.ok(visitor);
	}
	
	//create user visitor restAPI
	@PostMapping("/visitor")
	public Visitor createVisitor(@RequestBody Visitor visitor){
		return visitorRepository.save(visitor);
	}
	
	//update visitor
	@PutMapping("/visitor/{id}")
	public ResponseEntity<Visitor> updateVisitor(@PathVariable int id, @RequestBody Visitor visitorDetails) {
		Visitor visit = visitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Visitor not found with id: " + id));
		
//		visit.setId(visitorDetails.getId());
		visit.setVisitorName(visitorDetails.getVisitorName());
		visit.setVisitorAddress(visitorDetails.getVisitorAddress());
		visit.setVistingPurpose(visitorDetails.getVistingPurpose());
		visit.setContractors(visitorDetails.getContractors());
		visit.setVisitorEntryTime(visitorDetails.getVisitorEntryTime());
		visit.setVisitorOutingTime(visitorDetails.getVisitorOutingTime());
		visit.setPhone(visitorDetails.getPhone());
		
		Visitor updateVisitor = visitorRepository.save(visit);
		return ResponseEntity.ok(updateVisitor);
	}
	
//	delete visitor
	@DeleteMapping("/visitor/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVisitor(@PathVariable int id){
		Visitor visit = visitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Visitor not found with id: " + id));
		
		visitorRepository.delete(visit);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
