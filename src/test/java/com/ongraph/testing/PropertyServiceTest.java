package com.ongraph.testing;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.Assert;

import com.ongraph.test.models.Property;
import com.ongraph.test.services.Impl.PropertyServiceImpl;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JPAConfiguration.class })
public class PropertyServiceTest {

	@Autowired(required=true)
	PropertyServiceImpl service;
	
	@Before
	public void init() {
		service = new PropertyServiceImpl();
	}
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	
	@Test
	public void approvePropertyTest() throws Exception{
		Property entity = new Property();
		entity.setPropertyName("new colony");
		Property check = service.createProperty(entity);
		Property approvProperty = service.approveProperty(entity.getId());
		
		Assert.assertNotEquals(check.getApproved(), approvProperty.getApproved());
		
	}
	
	

	
	@Test
    public void getPropertyById_NotFoundTest() throws Exception{
		Long id = (long) 123;
		try {
			Property expectedEntity = service.getPropertyById(id);
	    } catch(Exception e) {
	        //if execution reaches here, 
	        //it indicates this exception was occured.
   	    }		
		//Assert.assertEquals(null, expectedEntity);

	}
	
	@Test
	public void updatePropertyTest() throws Exception{
		Property entity = new Property();
		entity.setPropertyName("new colony");
		
		Property newEntity = new Property();
		newEntity = service.createProperty(entity);
		
		newEntity.setPropertyName("main colony");
		Property expectedEntity = service.updateProperty(newEntity);
		
		Assert.assertEquals(newEntity.getPropertyName(), expectedEntity.getPropertyName());
	}
	
    @Test
	public void createPropertyTest() throws Exception {
		
		Property saveEntity = new Property();
		saveEntity.setPropertyName("new colony123");
		
		Property expEntity = service.createProperty(saveEntity);
		
		Assert.assertEquals(expEntity.getPropertyName(), saveEntity.getPropertyName());
	}
	
	@Test
    public void createProperty_BadTest() throws Exception{
		
		Property save = new Property();
		try {
			service.createProperty(save);
	    } catch(ConstraintViolationException e) {
	        //if execution reaches here, 
	        //it indicates this exception was occured.
   	    }		
		
	}
	
	@Test
	public void getAllPropertyTest() throws Exception{
		//service = new PropertyServiceImpl();
		Property entity = new Property();
		Property entity2 = new Property();
        entity.setPropertyName("new colony");
        entity2.setPropertyName("main colony");
        List<Property> list = new ArrayList<>();
        list.add(entity);
        list.add(entity2);
		list.forEach((newentity) -> {
			try {
				service.createProperty(newentity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		List<Property> expectedList = service.getAllProperty();
		Assert.assertEquals(list.size(), expectedList.size());
		
	} 
	
	
	
	
	
}
