package com.getechnologies.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.getechnologies.api.domain.Invoice;
import com.getechnologies.api.domain.params.InvoiceParams;
import com.getechnologies.api.exception.GenericException;

@Service
public interface InvoiceService {

	
	List<Invoice> findInvoicesByPerson(Long personId);
	
	Page<Invoice> getAllInvoicesByPerson(Long personId, int pageNo, int pageSize);
	
	Invoice generateInvoice(InvoiceParams request) throws GenericException;
	
	Invoice deleteInvoice(Long id) throws GenericException;
	
	
	
}
