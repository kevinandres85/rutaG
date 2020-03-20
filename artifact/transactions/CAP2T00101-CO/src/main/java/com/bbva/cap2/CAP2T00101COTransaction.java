package com.bbva.cap2;

import com.bbva.cap2.lib.r001.CAP2R001;
import com.bbva.cap2.lib.r001.impl.CAP2R001Abstract;
import com.bbva.cap2.lib.r001.impl.CAP2R001Impl;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.cap2.AbstractCAP2T00101COTransaction;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import com.bbva.cap2.dto.dto.*;

/**
 * transaccion de ruta
 * Implementacion de logica de negocio.
 * @author kluna
 *
 */
public class CAP2T00101COTransaction extends AbstractCAP2T00101COTransaction {
	private static final Logger LOGGER = LoggerFactory.getLogger(CAP2T00101COTransaction.class);

    		 /*
    		  * method execute
    		  * */
	@Override
	public void execute() {
		CAP2R001 CAP2R001abs= (CAP2R001) getServiceLibrary(CAP2R001.class);
	     DataIn dataIn = this.getDatain();
	    if(!validatePoints(dataIn)){
	    	LOGGER.info("error origen y destino iguales");
	    }
	    
	    DataOut dataOut = CAP2R001abs.execute(dataIn.getOrigin(), dataIn.getDestiny());
	    LOGGER.debug("Successful search");
		setContentLocation(getURIPath());
		setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);
		this.setDataOut(dataOut);
		
	}
	/*method to validate origin and destiny not same */

	private boolean validatePoints(DataIn dataIn) {
		if(dataIn.getOrigin().equals(dataIn.getDestiny())){
			return true;
		}
		return false;
	}

	

}
