package com.bbva.cap2.dto.dto;
import com.bbva.apx.dto.AbstractDTO;
public class DataIn extends AbstractDTO{
	
	private static final long serialVersionUID = -6062739952310782097L;
	private String origin;
	private String destiny;
	/**
	 * Constructor class
	 */
	
	public DataIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * origin to get 
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * origin to set 
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * destiny to get 
	 */

	public String getDestiny() {
		return destiny;
	}
	/**
	 * destiny to set 
	 */
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	
   
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destiny == null) ? 0 : destiny.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataIn other = (DataIn) obj;
		if (destiny == null) {
			if (other.destiny != null)
				return false;
		} else if (!destiny.equals(other.destiny))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DataIn [origin=" + origin + ", destiny=" + destiny + "]";
	}


	
	

}
