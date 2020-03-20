package com.bbva.cap2.lib.r001.impl;

import java.io.IOException;
import java.util.Arrays;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.cap2.dto.dto.DataOut;
import com.bbva.cap2.lib.r001.CAP2R001;
import org.springframework.web.client.RestTemplate;

public class CAP2R001Impl extends CAP2R001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CAP2R001.class);
	
	/**
	 * method conversion Json to Java Object
	 */
	@Override
	public DataOut execute(String orig, String dest) {
		
		DataOut dato=new DataOut();
		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject("https://maps.googleapis.com/maps/api/directions/json?origin=" + orig
				+ "&destination=" + dest + "&key=AIzaSyByPeqwGB3sb1BXGhEkzfzmnOodqugTM6Q", String.class);

		try {
			jsonValues(dato,json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			   
		  
	return dato;
	}
	/*
	 * method to return values origin and destiny from DataIn
	 */
	

	private void jsonValues(DataOut dato, String json) throws JsonProcessingException, IOException {
		JsonNode arrNode = new ObjectMapper().readTree(json).get("routes");

		JsonNode arr2 = null;
		String s3=null,s4=null;
		for (JsonNode objNode : arrNode) {

			String json2 = objNode.toString();
			arr2 = new ObjectMapper().readTree(json2).get("legs");
			for (JsonNode objNod : arr2) {

				s3 = new ObjectMapper().readTree(objNod.toString()).get("distance").toString();

				String[] ar = s3.split(",");
				String[] a2 = Arrays.toString(ar).split(":");

			    dato.setDistance(Long.parseLong(a2[2].replaceAll("}", "").replaceAll("]", "")));

			    s4=new ObjectMapper().readTree(objNod.toString()).get("duration").toString();
		           
                String[] ar2=s4.split(",");
                String[] a3=Arrays.toString(ar2).split(":");
                dato.setTime(Integer.parseInt(a3[2].replaceAll("}", "").replaceAll("]", "")));
			}
		}
		   dato.setCost(calcularcosto(dato.getDistance()));
		
	}

	/*
	 * Method to calculate cost with distance like parameter 
	 * */

	private double  calcularcosto(long distance) {
	     double res=0;
		
	     res=(distance/1000)*DataOut.getRate();
		
	     return res;
		
	}
	
}
