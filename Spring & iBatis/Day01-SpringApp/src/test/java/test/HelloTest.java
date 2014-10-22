package test;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml"})
public class HelloTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloTest.class);
	
	@Inject
	@Named("test1")
	String testObj;
	
	@Test
	public void testHello() {
		logger.info(testObj);
		System.out.println(testObj);
	}
	
}
