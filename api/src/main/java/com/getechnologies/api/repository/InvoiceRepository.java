package com.getechnologies.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.getechnologies.api.domain.Invoice;


public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	
	Invoice findInvoiceById(Long id);
	
    @Query(value = "SELECT c.* FROM invoice AS c WHERE c.persona_id LIKE %:id%",nativeQuery = true)
	List<Invoice> findInvoiceByPersona(Long id);
	
    @Query(value = "SELECT c.* FROM invoice AS c WHERE c.persona_id LIKE %:id%",nativeQuery = true)
	Page<Invoice> findInvoiceByPersona(Long id, Pageable pageable);

}
