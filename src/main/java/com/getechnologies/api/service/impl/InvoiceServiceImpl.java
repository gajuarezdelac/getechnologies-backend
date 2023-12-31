package com.getechnologies.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.getechnologies.api.domain.Invoice;
import com.getechnologies.api.domain.Person;
import com.getechnologies.api.domain.params.InvoiceParams;
import com.getechnologies.api.exception.GenericException;
import com.getechnologies.api.repository.InvoiceRepository;
import com.getechnologies.api.repository.PersonRepository;
import com.getechnologies.api.service.InvoiceService;




@Component
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
		
	final static Logger logger = Logger.getLogger(InvoiceServiceImpl.class);

	@Autowired
	private InvoiceRepository repo;
	
	@Autowired
	private PersonRepository repoPerson;
	
	@Override
	public List<Invoice> findInvoicesByPerson(Long personId) {
		logger.info("Method: "  + "findInvoicesByPerson" + "Params: " + personId);
		return repo.findInvoiceByPersona(personId);
	}

	@Override
	public Page<Invoice> getAllInvoicesByPerson(Long personId, int pageNo, int pageSize) {
		logger.info("Method: "  + "getAllInvoicesByPerson" + "Params: " + personId);
		Pageable pageable = PageRequest.of(pageNo, pageSize);   
		Page<Invoice> response = repo.findInvoiceByPersona(personId, pageable);
		return response;		
	}

	@Override
	public Invoice generateInvoice(InvoiceParams request) throws GenericException {
		logger.info("Method: "  + "generateInvoice " + "Params: " + request.toString());
		Invoice r = new Invoice();
		Person person = existPerson(request.getPersona());
		
		r.setFechaCreacion(new Date());
		r.setMonto(request.getMonto());
		r.setPersona(person);
		
		repo.save(r);

		return r;
	}

	@Override
	public Invoice deleteInvoice(Long id) throws GenericException {
		logger.info("Method: "  + "deleteInvoice " + "Params: " + id);
		Invoice elemento = existInvoice(id);
		repo.deleteById(id);
		return elemento;
	}
	
	
	private Person existPerson(Long id) throws GenericException {
		logger.info("Method: "  + "existPerson " + "Params: " + id);
		Person p = repoPerson.findPersonById(id);
		
		if(p == null) {
			throw new GenericException("No hemos encontrado a la persona");
		}
	
		return p;	
	}
	
	
	private Invoice existInvoice(Long id) throws GenericException {
		logger.info("Method: "  + "existInvoice " + "Params: " + id);
		Invoice p = repo.findInvoiceById(id);
		
		if(p == null) {
			throw new GenericException("No hemos encontrado a la factura");
		}
	
		return p;	
		
	}
	
	
	
	

}
