package com.getechnologies.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.getechnologies.api.domain.Person;
import com.getechnologies.api.domain.params.PersonParams;
import com.getechnologies.api.exception.GenericException;


@Service
public interface PersonService {
	
	Person findPeopleByIdentification(String identification) throws GenericException;
	
	List<Person> getAllPeople();
	
	Page<Person> getAllPeoplePaginate(int pageNo, int pageSize);
	
	Person deleteByIdentification(Long id) throws GenericException;
	
	Person createPerson(PersonParams request) throws GenericException;
	
	Person editPerson(Long id, PersonParams request) throws GenericException;


}
