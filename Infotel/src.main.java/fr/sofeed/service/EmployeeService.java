package fr.sofeed.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import fr.sofeed.bean.Employee;
import fr.sofeed.bean.Event;
import fr.sofeed.bean.Project;

@Path("/employee")
public class EmployeeService {
	
	@GET
	@Path("/list")
	public List<Employee> getEmployees(){
		return null;
	}
	
	@GET
	@Path("/{id}")
	public Employee getEmployee(@PathParam("id") int id){
		Employee employee = null;
		return employee;
	}
	
	@POST
	@Path("/")
	public int createEmployee(Employee employee){
		// TODO return id or page 
		return 0;
	}
	
	@GET
	@Path("/search")
	public List<Employee> searchEmployee(
			@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName,
			@QueryParam("project") Project project,
			@QueryParam("agency") String agency){
		return null;
	}
	
	@GET
	@Path("{id}/event/list")
	public List<Event> getEvents(@QueryParam("id") int id){
		return null;
	}
	
	@GET
	@Path("{id}/project/list")
	public List<Project> getProjects(@QueryParam("id") int id){
		return null;
	}
	
	@GET
	@Path("{id}/ticket/list")
	public List<Project> getTickets(@QueryParam("id") int id){
		return null;
	}
	
	@POST
	@Path("{id}")
	public void deleteEmployee(@QueryParam("id") int id){
		
	}
}
