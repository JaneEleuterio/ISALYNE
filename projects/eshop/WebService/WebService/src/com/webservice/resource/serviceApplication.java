package com.webservice.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class serviceApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rrcs = new HashSet<Class<?>>();
		rrcs.add(serviceVisaResource.class);
		rrcs.add(serviceMasterResource.class);
		return rrcs;
	}

}
