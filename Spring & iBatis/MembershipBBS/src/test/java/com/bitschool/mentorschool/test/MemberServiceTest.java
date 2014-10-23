package com.bitschool.mentorschool.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitschool.mentorschool.service.MemberService;

public class MemberServiceTest extends TestConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	
	@Inject
	private MemberService service;
	
	@Test
	public void testDAO() {
		
		service.checkLogin(null);
		
	}
	
}
