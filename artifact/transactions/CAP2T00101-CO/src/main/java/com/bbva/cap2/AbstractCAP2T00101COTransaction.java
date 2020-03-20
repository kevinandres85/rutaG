package com.bbva.cap2;


import com.bbva.cap2.dto.dto.*;
import com.bbva.cap2.lib.r001.CAP2R001;
import com.bbva.elara.transaction.AbstractTransaction;

public abstract class AbstractCAP2T00101COTransaction extends AbstractTransaction {

	
	public AbstractCAP2T00101COTransaction(){
	}
	protected DataIn getDatain(){
		return (DataIn) getParameter("DataIn");
	}
	protected void setDataOut(final DataOut field){
		this.addParameter("dataOut", field);
	}
	

	/**
	 * Set value for output parameter type
	 */
	protected void setType(final DataOut field){
		this.addParameter("type", field);
	}			
	
	

	
	

}
