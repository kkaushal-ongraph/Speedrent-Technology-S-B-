package com.ongraph.test.services;

import java.util.List;

import com.ongraph.test.models.Property;

public interface PropertyService {

	public List<Property> getAllProperty();
	
	public Property getPropertyById(Long id) throws Exception ;
	
	public Property updateProperty(Property entity) throws Exception;
	
	public Property approveProperty(Long id) throws Exception;
	
	public Property createProperty(Property entity) throws Exception;
}
