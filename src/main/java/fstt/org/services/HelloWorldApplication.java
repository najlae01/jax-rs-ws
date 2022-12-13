package fstt.org.services;

import org.glassfish.jersey.server.ResourceConfig;

public class HelloWorldApplication extends ResourceConfig{
	
	public HelloWorldApplication(){

		packages("fstt.org.controllers");
	}
}
