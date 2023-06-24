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

import com.getechnologies.api.domain.Invoice;
import com.getechnologies.api.domain.params.InvoiceParams;
import com.getechnologies.api.exception.GenericException;
import com.getechnologies.api.service.InvoiceService;


@RestController
@RequestMapping(path = {"/invoice"})
public class InvoiceController{

   @Autowired 
   InvoiceService service;
	
    @GetMapping("/get-by-person/{id}")
	public ResponseEntity<List<Invoice>> findInvoicesByPerson(@PathVariable(value = "id")  Long personId) {
		List<Invoice> response = service.findInvoicesByPerson(personId);
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}

    @GetMapping("/get-by-person-paginate")
	public ResponseEntity<Page<Invoice>> getAllInvoicesByPerson(
			@RequestParam(value = "person", required = true) Long personId,
			@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
			) {
		Page<Invoice> response = service.getAllInvoicesByPerson(personId, pageNo, pageSize);
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}

    @PostMapping("/create")
	public ResponseEntity<Invoice> generateInvoice(@RequestBody InvoiceParams request) throws GenericException {
		Invoice response = service.generateInvoice(request);
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}

	@DeleteMapping("/delete-invoice/{id}")
	public ResponseEntity<Invoice> deleteInvoice(@PathVariable(value = "id") Long id) throws GenericException {
		Invoice response = service.deleteInvoice(id);
	    return new ResponseEntity<>(response , HttpStatus.OK);
	}

}
