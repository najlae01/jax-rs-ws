package fstt.org.controllers;


import fstt.org.entities.Station;
import fstt.org.services.StationRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.view.Viewable;


@Path("/station")
public class StationController{

	StationRepository stationRepository = new StationRepository();
	
	@Path("/hello")
	@GET
	public String sayDefault() {
		return "Hello Rest Api";
	}
	
	@Path("/save")
	@GET
	public Viewable save(
			@Context HttpServletRequest request,
		    @Context HttpServletResponse response) throws Exception{
		return new Viewable("addStation.jsp", request);
	}

	@Path("/saved/{request}")
	@POST
	public Viewable saved(
			@Context HttpServletRequest request,
		    @Context HttpServletResponse response) throws Exception{
		Station station;

		String name = request.getParameter("name");

		String address = request.getParameter("address");

		String city = request.getParameter("city");

		station = new Station(name, city, address);

		create(station);

		return new Viewable("stations.jsp");
	}
	
	@Path("/update/{id}")
	@GET
	public Viewable update(@PathParam("id") Long id,
			@Context HttpServletRequest request,
		    @Context HttpServletResponse response) throws Exception{
		
		Station stationExists = getOne(id);

		request.setAttribute("oldName", stationExists.getNom());

		request.setAttribute("oldAddress", stationExists.getAdresse());

		request.setAttribute("oldCarbs", stationExists.getStationCarbs());

		request.setAttribute("oldCity", stationExists.getVille());

		request.setAttribute("id", stationExists.getId());
		
		return new Viewable("updateStation.jsp", request);
	}

	@Path("/updated/{request}")
	@POST
	public Viewable updated(
			@Context HttpServletRequest request,
		    @Context HttpServletResponse response) throws Exception{
		Station station;

		String name = request.getParameter("name");

		String address = request.getParameter("address");

		String city = request.getParameter("city");
		
		Long id = Long.parseLong(request.getParameter("id"));


		station = new Station(id, name, city, address);

		update(id, station);
		
		return new Viewable("stations.jsp");
	}
	
	@Path("/delete/{id}")
	@GET
	public Viewable delete(@PathParam("id") Long id,
			@Context HttpServletRequest request,
		    @Context HttpServletResponse response) throws Exception{

		delete(id);
		return new Viewable("stations.jsp");
	}
	
	@Path("/list")
	@GET
	public Viewable list(@Context HttpServletRequest request,
		    @Context HttpServletResponse response) throws Exception{

		List<Station> list = new ArrayList<Station>();
		list = getAll();

		request.setAttribute("list", list);
		return new Viewable("stations.jsp", request);
	}
	
	@Path("/get/{id}")
	@GET
	public Viewable get(@PathParam("id") Long id,
			@Context HttpServletRequest request,
		    @Context HttpServletResponse response) throws Exception{

		Station station = getOne(id);

		request.setAttribute("station", station);
		return new Viewable("getStation.jsp", request);
	}


	public Station getOne(Long id) throws IOException {
		return stationRepository.findStationById(id);
	}

	public List<Station> getAll() {
		return stationRepository.findAll();
	}

	public void create(Station station) {
		stationRepository.createStation(station);
	}

	public void update(Long id, Station station) throws IOException {
		stationRepository.updateStation(id, station);
	}

	public void delete(Long stationId) throws IOException {
		stationRepository.deleteStation(stationId);
	}
}