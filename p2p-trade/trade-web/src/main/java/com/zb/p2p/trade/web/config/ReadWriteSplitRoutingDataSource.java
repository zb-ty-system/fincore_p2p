package com.zb.p2p.trade.web.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {
	
	@Override
	protected Object determineCurrentLookupKey() {
		return DataBaseContextHolder.getDataBaseType().getCode();
	}
	  
	  
	  
}
