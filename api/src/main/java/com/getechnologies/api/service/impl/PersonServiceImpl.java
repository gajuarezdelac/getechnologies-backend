package com.getechnologies.api.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.getechnologies.api.domain.Person;
import com.getechnologies.api.domain.params.PersonParams;
import com.getechnologies.api.exception.GenericException;
import com.getechnologies.api.repository.PersonRepository;
import com.getechnologies.api.service.PersonService;


@Component
@Transactional
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository repo;

	@Override
	public Person findPeopleByIdentification(String identification) throws GenericException {
		return existIdentification(identification);
	}

	@Override
	public List<Person> getAllPeople() {
		return repo.findAll();
	}

	@Override
	public Page<Person> getAllPeoplePaginate(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);   
		Page<Person> response = repo.findAll(pageable);
		return response;
	}

	@Override
	public Person deleteByIdentification(Long id) throws GenericException {
		Person p = existPerson(id);
		repo.deleteById(id);
		return p;
	}

	@Override
	public Person createPerson(PersonParams request) throws GenericException {
		
		validaIdentification(request.getIdentificacion());
		Person res = new Person();
		
		res.setApellidoMaterno(request.getApellidoMaterno());
		res.setApellidoPaterno(request.getApellidoPaterno());
		res.setIdentificacion(request.getIdentificacion());
		res.setNombre(request.getNombre());
		
		repo.save(res);
		
		return res;
	}
	
	
	private Person validaIdentification(String identification) throws GenericException {
		
		Person p = repo.findPersonByIdentificacion(identification);
		
		if(p != null) {
			throw new GenericException("Dicha identificación ya existe");
		}
		
		return p;
	}
	
	
	private Person existIdentification(String identification) throws GenericException {
		
		Person p = repo.findPersonByIdentificacion(identification);
		
		if(p == null) {
			throw new GenericException("Dicha identificación no existe");
		}
		
		return p;
	}
	
	
	
	
	private Person existPerson(Long id) throws GenericException {
		
	Person p = repo.findPersonById(id);
		
		if(p == null) {
			throw new GenericException("No hemos encontrado la persona");
		}
		
		return p;
		
	}
	
	

}
