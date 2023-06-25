package com.getechnologies.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getechnologies.api.domain.Person;
import com.getechnologies.api.domain.params.PersonParams;
import com.getechnologies.api.exception.GenericException;
import com.getechnologies.api.service.PersonService;

@RestController
@RequestMapping(path = {"/person"})
public class PersonController {
	

	@Autowired 
	PersonService service;

	@GetMapping("/get-by-identification/{id}")
	public ResponseEntity<Person> findPeopleByIdentification(@PathVariable(value = "id") String identification) throws GenericException {
		Person response = service.findPeopleByIdentification(identification);
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}

	@GetMapping("/get-all")
	public ResponseEntity<List<Person>> getAllPeople() {
		List<Person> response = service.getAllPeople();
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}

	@GetMapping("/get-all-paginate")
	public ResponseEntity<Page<Person>> getAllPeoplePaginate(
	@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
	@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		Page<Person> response = service.getAllPeoplePaginate(pageNo, pageSize);
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}

	@DeleteMapping("/delete-by-id/{id}")
	public ResponseEntity<Person> deleteByIdentification(@PathVariable(value = "id") Long id) throws GenericException {
		Person response = service.deleteByIdentification(id);
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody PersonParams request) throws GenericException {
		Person response = service.createPerson(request);
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}
	
	 @PostMapping("/update/{id}")
		public ResponseEntity<Person> editInvoice(@PathVariable(value = "id")  Long personId, @RequestBody PersonParams request) throws GenericException {
		  Person response = service.editPerson(personId, request);
		    return new ResponseEntity<>(response , HttpStatus.OK);
	 }

}
