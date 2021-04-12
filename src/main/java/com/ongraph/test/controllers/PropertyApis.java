package com.ongraph.test.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ongraph.test.models.Property;

@RequestMapping("/api/property")
public interface PropertyApis {
	
	@GetMapping
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<List<Property>> getAllProperty();
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<Property> getPropertyId(@PathVariable("id") Long id) throws Exception ;
	
	@PostMapping
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<Property> createProperty(@RequestBody Property property) throws Exception ;
	
	@PutMapping
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<Property> updateProperty(@RequestBody  Property property) throws Exception ;
	
	@GetMapping("/approve/{id}")
	@PreAuthorize(" hasRole('ADMIN')")
	public ResponseEntity<Property> approveById(@PathVariable("id") Long id) throws Exception;

}
