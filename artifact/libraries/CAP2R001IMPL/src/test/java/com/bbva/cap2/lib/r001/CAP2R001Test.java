package com.bbva.cap2.lib.r001;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.cap2.lib.r001.impl.CAP2R001Abstract;
import com.bbva.cap2.lib.r001.impl.CAP2R001Impl;
import com.bbva.cap2.dto.dto.*;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/CAP2R001-app.xml",
		"classpath:/META-INF/spring/CAP2R001-app-test.xml",
		"classpath:/META-INF/spring/CAP2R001-arc.xml",
		"classpath:/META-INF/spring/CAP2R001-arc-test.xml" })
public class CAP2R001Test {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CAP2R001.class);
	
	@Resource(name = "cap2R001")
	private CAP2R001 cap2R001;
	
	@Before
	public void setUp() throws Exception {		
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.cap2R001;
		if(this.cap2R001 instanceof Advised){
			Advised advised = (Advised) this.cap2R001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		LOGGER.info("Executing the test...");
		
	}
	
	@Test 
	public void jsonvaluesTest(){
		DataOut response= cap2R001.execute("Bogota", "Medellin");
		
		Assert.assertEquals(response.getDistance(), 415450);
		Assert.assertEquals(response.getTime(), 29546);
		Assert.assertEquals(response.getRate(), 2000.0);
		Assert.assertEquals(response.getCost(), 830000.0);
		
		
		
	}
	
	
	
}
