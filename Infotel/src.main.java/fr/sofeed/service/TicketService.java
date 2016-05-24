package fr.sofeed.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import fr.sofeed.bean.Ticket;
import fr.sofeed.utils.HibernateUtils;
import fr.sofeed.utils.TicketUtils;

@Path("/ticket")
public class TicketService {
	
	private Session session;

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTicket(Ticket ticket){
		session = HibernateUtils.getSession();
		session.beginTransaction();
		session.save(ticket);
		session.getTransaction().commit();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket getTicket(@PathParam("id") int id){
		Ticket ticket = TicketUtils.findTicketById(id);
		return ticket;
	}
	@POST
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteTicket(@PathParam("id") int id){
		session = HibernateUtils.getSession();
		Ticket ticket = TicketUtils.findTicketById(id);
		session.beginTransaction();
		session.delete(ticket);
		session.getTransaction().commit();
	}

}
