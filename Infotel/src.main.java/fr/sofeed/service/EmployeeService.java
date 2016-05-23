package fr.sofeed.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.sofeed.bean.Employee;
import fr.sofeed.bean.Event;
import fr.sofeed.bean.Project;
import fr.sofeed.utils.HibernateUtils;

@Path("/employee")
public class EmployeeService {
	private Session session;
	
//	@GET
//	@Path("/list")
//	public List<Employee> getEmployees(){
//		return null;
//	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int id){
		Employee employee = findEmployeeById(id);
		return employee;
	}
	
	private Employee findEmployeeById(int id) {
		session = HibernateUtils.getSession();
		Employee employee = null;
		List results = session.createCriteria(Employee.class)
				.setMaxResults(1)
				.add(Restrictions.idEq(id))
				.list();
		if (!results.isEmpty()){
			employee = (Employee) results.get(0);
		}
		return employee;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEmployee(Employee employee){
		session = HibernateUtils.getSession();
		session.save(employee);
		return Response.status(200).entity(employee).build();
	}
//	
//	@GET
//	@Path("/search")
//	public List<Employee> searchEmployee(
//			@QueryParam("firstName") String firstName,
//			@QueryParam("lastName") String lastName,
//			@QueryParam("project") Project project,
//			@QueryParam("agency") String agency){
//		return null;
//	}
//	
//	@GET
//	@Path("{id}/event/list")
//	public List<Event> getEvents(@QueryParam("id") int id){
//		return null;
//	}
//	
//	@GET
//	@Path("{id}/project/list")
//	public List<Project> getProjects(@QueryParam("id") int id){
//		return null;
//	}
//	
//	@GET
//	@Path("{id}/ticket/list")
//	public List<Project> getTickets(@QueryParam("id") int id){
//		return null;
//	}
//	
//	@POST
//	@Path("{id}")
//	public void deleteEmployee(@QueryParam("id") int id){
//		
//	}
}
