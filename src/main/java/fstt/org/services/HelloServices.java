package fstt.org.services;

import jakarta.ws.rs.GET;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/monservice")
public class HelloServices {

	@Path("hello")
	@GET
	public String sayDefault() {
		return "Hello Rest Api";
	}
	
	@Path("/message/{message}")
	@GET
	public String sayHello(@PathParam("message") String msg) {
		return "Hello "+ msg;
	}

	@Path("/addition/{a}/{b}")
	@POST
	public String add(@PathParam("a") int a, @PathParam("b") int b) {
		return String.valueOf(a+b);
	}
}