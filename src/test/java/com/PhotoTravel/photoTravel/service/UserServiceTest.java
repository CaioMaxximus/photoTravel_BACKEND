package com.PhotoTravel.photoTravel.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.PhotoTravel.photoTravel.error.ResourceAlreadyExistsException;
import com.PhotoTravel.photoTravel.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
	UserService userService;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
	}
	
	
	
	@Test
	public void addUserTest() {
		
		//Testing user creation
		//Testing equal names for users
//		User a = new User("a", "aemail.com", "123", "");
//		User ab = new User("a", "aemail.com", "123" ,"");
//		try{
//			userService.addUser(a);
//			userService.addUser(ab);
//			fail("Equal nick user shoul thrown an exception");
//		}catch(ResourceAlreadyExistsException error){
//			assertThat(error.getMessage() ,is("User nick already exists") );
//			
//		}
		//Tewsting equal emails for users
//		User b =new User("b", "aemail.com", "123");
//		User c =new User("c", "aemail.com", "123");
	}

}
