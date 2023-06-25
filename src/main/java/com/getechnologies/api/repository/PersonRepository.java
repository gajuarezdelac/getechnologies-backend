package com.getechnologies.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getechnologies.api.domain.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{
	
	
	Person findPersonByIdentificacion(String identificacion);

	Person findPersonById(Long id);

}
