package com.PhotoTravel.photoTravel.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.PhotoTravel.photoTravel.model.User;

public class UserServiceTest {

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
		fail("Not yet implemented");
	}
	
	@Rule
	UserService service = new UserService(null); 
	
	@Test
	public void addUserTest() {
		
		//Testing user creation
		User newU = new User("newUser0", "emailUser" ,"123" );
		
		//Testing equal names for users
		User a = new User("a", "aemail.com", "123");
		User ab = new User("a", "aemail.com", "123");
		//Tewsting equal emails for users
		User b =new User("b", "aemail.com", "123");
		User c =new User("c", "aemail.com", "123");
	}

}
