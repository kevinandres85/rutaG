package com.bbva.cap2.lib.r001;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bbva.cap2.dto.dto.DataOut;

public interface CAP2R001 {

	public DataOut execute(String orig,String dest);

	

}
