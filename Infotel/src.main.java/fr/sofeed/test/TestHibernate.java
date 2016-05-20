package fr.sofeed.test;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.sofeed.bean.Document;
import fr.sofeed.bean.Employee;
import fr.sofeed.bean.Event;
import fr.sofeed.bean.Project;
import fr.sofeed.bean.Ticket;
import fr.sofeed.utils.HibernateUtils;

public class TestHibernate {
	
	public static void main(String[]args){
//		Employee emp = new Employee();
//		emp.setAdresse("Rue des Oliviers");
//		emp.setAgency("Mougins");
//		emp.setBirthDate(new Date());
//		emp.setEmail("email@telecom.com");
//		emp.setName("Florian");
//		emp.setSurname("BouBou");
//		emp.setProfilPicture("./test");
//		emp.setTelephone("00000");
//		
//		Session session = HibernateUtils.getSession();
//		session.beginTransaction();
//		Criteria crit_projects = session.createCriteria(Project.class);
//		emp.setProjects((Set<Project>)crit_projects.list());
//		Criteria crit_tickets = session.createCriteria(Ticket.class);
//		emp.setTickets((Set<Ticket>)crit_tickets.list());
//		Criteria crit_events = session.createCriteria(Event.class);
//		emp.setEvents((Set<Event>)crit_events.list());
//		session.save(emp);
//		session.getTransaction().commit();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Project project = new Project();
		project.setInformation("Voici un autre test");
		project.setName("test2");
		project.setStartDate(new Date());
		Document document = new Document();
		document.setDate(new Date());
		document.setName("CP réu");
		document.setPath("~/cpreu.txt");
		Set<Document> documents = new HashSet<Document>();
		documents.add(document);
		session.save(project);
		session.getTransaction().commit();
	}

}
