package com.ongraph.test.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ongraph.test.constants.ErrorContstants;
import com.ongraph.test.exception.BadRequestException;
import com.ongraph.test.models.Property;
import com.ongraph.test.repository.PropertyRepository;
import com.ongraph.test.services.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService{

	@Autowired
	PropertyRepository _propertyRepository;

	@Override
	public List<Property> getAllProperty() {
		List<Property> propertyList = _propertyRepository.findAll();

		if (propertyList.size() > 0) {
			return propertyList;
		} else {
			return new ArrayList<Property>();
		}
	}

	@Override
	public Property getPropertyById(Long id) throws Exception {
		Optional<Property> property = _propertyRepository.findById(id);

		if (property.isPresent()) {
			return property.get();
		} else {

			throw new BadRequestException(ErrorContstants.PROPERTY_NOT_EXISIT);
		}
	}

	@Override
	public Property updateProperty(Property entity) throws Exception {

		Optional<Property> property = _propertyRepository.findById(entity.getId());

		if (property.isPresent()) {
			Property newEntity = property.get();
			newEntity.setPropertyName(entity.getPropertyName());

			newEntity = _propertyRepository.save(newEntity);

			return newEntity;
		} else {
			throw new BadRequestException(ErrorContstants.PROPERTY_NOT_EXISIT);
		}

	}

	@Override
	public Property approveProperty(Long id) throws Exception {

		Optional<Property> property = _propertyRepository.findById(id);

		if (property.isPresent()) {
			Property newEntity = property.get();
			newEntity.setApproved(Boolean.TRUE);;

			newEntity = _propertyRepository.save(newEntity);

			return newEntity;
		} else {
			throw new BadRequestException(ErrorContstants.PROPERTY_NOT_EXISIT);
		}

	}
	
	@Override
	public Property createProperty(Property entity) throws Exception {

		entity = _propertyRepository.save(entity);

		return entity;
	}

}
