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
import fr.sofeed.bean.Project;
import fr.sofeed.bean.Ticket;
import fr.sofeed.utils.EmployeeUtils;
import fr.sofeed.utils.HibernateUtils;
import fr.sofeed.utils.ProjectUtils;

@Path("/project")
public class ProjectService {
	private Session session;
	
	@GET
	@Path("{id}")
	@Produces
	public Project getProject(@PathParam("id") int id){
		Project project = ProjectUtils.findProjectById(id);
		return project;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProject(Project project){
		session = HibernateUtils.getSession();
		session.save(project);
		return Response.status(200).build();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getProjects(){
		session = HibernateUtils.getSession();
		Criteria crit = session.createCriteria(Project.class);
		return (List<Project>)crit.list();
	}
	
	@GET
	@Path("{id}/participant/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getParticipants(@PathParam("id") int id){
		Project project = ProjectUtils.findProjectById(id);
		return project.getTeam();
	}
	
	@POST
	@Path("{id}/participant/{employeeId}/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addParticipant(@PathParam("id") int id, @PathParam("employeeId") int employeeId){
		Employee emp = EmployeeUtils.findEmployeeById(employeeId);
		Project project = ProjectUtils.findProjectById(id);
		List<Employee> team = project.getTeam();
		team.add(emp);
		project.setTeam(team);
		session = HibernateUtils.getSession();
		session.save(project);
		return;
	}
	
	@POST
	@Path("{id}/participant/{employeeId}/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteParticipant(@PathParam("id") int id, @PathParam("employeeId") int employeeId){
		Employee emp = EmployeeUtils.findEmployeeById(employeeId);
		Project project = ProjectUtils.findProjectById(id);
		List<Employee> team = project.getTeam();
		team.remove(emp);
		project.setTeam(team);
		session = HibernateUtils.getSession();
		session.save(project);
		return;
	}
	
	@GET
	@Path("{id}/ticket/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getTickets(@PathParam("id") int id){
		Project project = ProjectUtils.findProjectById(id);
		return project.getTickets();
	}
}
