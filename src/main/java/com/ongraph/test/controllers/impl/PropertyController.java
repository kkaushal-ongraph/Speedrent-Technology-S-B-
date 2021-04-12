package com.ongraph.test.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ongraph.test.controllers.PropertyApis;
import com.ongraph.test.models.Property;
import com.ongraph.test.services.PropertyService;

@RestController
public class PropertyController implements PropertyApis{
	@Autowired
	PropertyService propertyService;

    @Override
	public ResponseEntity<List<Property>> getAllProperty() {
		List<Property> list = propertyService.getAllProperty();

		return new ResponseEntity<List<Property>>(list, new HttpHeaders(), HttpStatus.OK);
	}

    @Override
	public ResponseEntity<Property> getPropertyId(@PathVariable("id") Long id) throws Exception {
		Property entity = propertyService.getPropertyById(id);

		return new ResponseEntity<Property>(entity, new HttpHeaders(), HttpStatus.OK);
	}

    @Override
	public ResponseEntity<Property> createProperty(@RequestBody Property property) throws Exception {
		Property updated = propertyService.createProperty(property);
		return new ResponseEntity<Property>(updated, new HttpHeaders(), HttpStatus.OK);
	}

    @Override
	public ResponseEntity<Property> updateProperty(@RequestBody  Property property) throws Exception {
		Property updated = propertyService.updateProperty(property);
		return new ResponseEntity<Property>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
    @Override
	public ResponseEntity<Property> approveById(@PathVariable("id") Long id) throws Exception {
		Property entity = propertyService.approveProperty(id);

		return new ResponseEntity<Property>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	
}
