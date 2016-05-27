package fr.sofeed.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import javax.imageio.stream.ImageOutputStreamImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sun.xml.bind.api.impl.NameConverter.Standard;

import fr.sofeed.bean.Employee;
import fr.sofeed.bean.Event;
import fr.sofeed.bean.Project;
import fr.sofeed.bean.Ticket;
import fr.sofeed.utils.EmployeeUtils;
import fr.sofeed.utils.HibernateUtils;

@Path("/employee")
public class EmployeeService {
	private Session session;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(){
		session = HibernateUtils.getSession();
		Criteria crit = session.createCriteria(Employee.class);
		return (List<Employee>)crit.list();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int id){
		Employee employee = EmployeeUtils.findEmployeeById(id);
		return employee;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEmployee(Employee employee) throws IOException{
		session = HibernateUtils.getSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		return Response.status(200).build();
	}
	
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> searchEmployee(
			@QueryParam("name") String firstName,
			@QueryParam("surname") String lastName,
			@QueryParam("agency") String agency){
		session = HibernateUtils.getSession();
		Criteria crit = session.createCriteria(Employee.class);
		if (firstName!=null)crit.add(Restrictions.like("name", "%"+firstName+"%"));
		if (lastName!=null)crit.add(Restrictions.like("surname", "%"+lastName+"%"));
		if (agency!=null)crit.add(Restrictions.like("agency", "%"+agency+"%"));
		return (List<Employee>) crit.list();
	}
	
	@GET
	@Path("{id}/event/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getEvents(@PathParam("id") int id){
		session = HibernateUtils.getSession();
		Employee employee = EmployeeUtils.findEmployeeById(id);	
		return employee.getEvents();
	}
	
	@GET
	@Path("{id}/project/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getProjects(@PathParam("id") int id){
		session = HibernateUtils.getSession();
		Employee employee = EmployeeUtils.findEmployeeById(id);	
		return employee.getProjects();
	}
	
	@GET
	@Path("{id}/ticket/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getTickets(@PathParam("id") int id){
		session = HibernateUtils.getSession();
		Employee employee = EmployeeUtils.findEmployeeById(id);	
		session.close();
		return employee.getTickets();
	}
	
	@POST
	@Path("/modify/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifyEmployee(@PathParam("id") int id,
			@QueryParam("name")String name,
			@QueryParam("agency")String agency){
		session = HibernateUtils.getSession();
		Employee employee  = EmployeeUtils.findEmployeeById(id);
		if (name!=null)employee.setName(name);
		if (agency!=null)employee.setAgency(agency);
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}
}
