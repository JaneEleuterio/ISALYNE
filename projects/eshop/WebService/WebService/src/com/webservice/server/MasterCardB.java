package com.webservice.server;

import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.ext.jaxrs.JaxRsApplication;

import com.webservice.resource.serviceApplication;

public class MasterCardB {

	public static void main(String[] args) {
		
		try {			
			Component comp = new Component();
			Server server = comp.getServers().add(Protocol.HTTP, 8184);
			
			JaxRsApplication application = new JaxRsApplication(comp.getContext().createChildContext());
			
			application.add(new serviceApplication());
			
			comp.getDefaultHost().attach(application);
			comp.start();
			
			System.out.println("Servidor rodando na porta " + server.getPort());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
