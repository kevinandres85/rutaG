package com.bbva.cap2.lib.r001.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.cap2.lib.r001.CAP2R001;

public abstract class CAP2R001Abstract extends AbstractLibrary implements CAP2R001 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CAP2R001.class);
	
	protected ApplicationConfigurationService applicationConfigurationService;
	
	/**
	 * @param applicationConfigurationService the applicationConfigurationService to set
	 */
	public void setApplicationConfigurationService(
			ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}
	
}
