package fr.sofeed.service;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import fr.sofeed.bean.Employee;
import fr.sofeed.bean.Event;

@Path("/event")
public class EventService {
	
	@GET
	@Path("{id}")
	public Event getEvent(@PathParam("id") int id){
		return null;
	}
	
	@POST
	@Path("/")
	public int createEvent(Event event){
		//TODO return link to created event
		return 0;
	}
	
	@GET
	@Path("/list")
	public List<Event> getEvents(){
		return null;
	}
	
	@GET
	@Path("{id}/participant/list")
	public List<Employee> getParticipants(@PathParam("id") int id){
		return null;
	}
	@POST
	@Path("{id}/participant/employeeId")
	public void addParticipant(@PathParam("id") int id, @PathParam("employeeId") int employeeId){
		
	}
	
	@POST
	@Path("{id}")
	public void modifyEvent(@PathParam("id") int id, Event event){
		
	}
	
	@GET
	@Path("/search")
	public List<Event> searchEvents(
			@QueryParam("name") String name,
			@QueryParam("startDate") Date startDate,
			@QueryParam("endDate") Date endDate,
			@QueryParam("type") String type,
			@QueryParam("location") String location){
		return null;
	}

}
