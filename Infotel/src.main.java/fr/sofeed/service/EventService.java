package fr.sofeed.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.sofeed.bean.Employee;
import fr.sofeed.bean.Event;
import fr.sofeed.utils.EmployeeUtils;
import fr.sofeed.utils.EventUtils;
import fr.sofeed.utils.HibernateUtils;

@Path("/event")
public class EventService {
	private Session session;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Event getEvent(@PathParam("id") int id){
		Event event = EventUtils.findEventById(id);
		return event;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEvent(Event event){
		session = HibernateUtils.getSession();
		session.beginTransaction();
		session.save(event);
		session.getTransaction().commit();
		return  Response.status(200).build();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getEvents(){
		session = HibernateUtils.getSession();
		Criteria crit = session.createCriteria(Event.class);
		List<Event>events = (List<Event>) crit.list();
		session.close();
		return events;
	}
	
	@GET
	@Path("{id}/participant/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getParticipants(@PathParam("id") int id){
		Event event = EventUtils.findEventById(id);
		return event.getParticipants();
	}
	
	@POST
	@Path("{id}/participant/{employeeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addParticipant(@PathParam("id") int id, @PathParam("employeeId") int employeeId){
		Employee emp = EmployeeUtils.findEmployeeById(employeeId);
		Event event = EventUtils.findEventById(id);
		List<Employee> participant = event.getParticipants();
		participant.add(emp);
		event.setParticipants(participant);
		session = HibernateUtils.getSession();
		session.beginTransaction();
		session.save(event);
		session.getTransaction().commit();
	}
	
	@POST
	@Path("/modify")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifyEvent(Event event){
		int id = event.getId();
		Event to_modify = EventUtils.findEventById(id);
		if (event.getName()!=null && event.getName()!=""){
			to_modify.setName(event.getName());
		}
		session.beginTransaction();
		session.save(to_modify);
		session.getTransaction().commit();
	}
	
//	@GET
//	@Path("/search")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Event> searchEvents(
//			@QueryParam("name") String name,
//			@QueryParam("startDate") Date startDate,
//			@QueryParam("endDate") Date endDate,
//			@QueryParam("type") String type,
//			@QueryParam("location") String location){
//		return null;
//	}

}
