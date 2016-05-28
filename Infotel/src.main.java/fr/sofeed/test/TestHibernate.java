package fr.sofeed.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
	
	public static void main(String[]args) throws ParseException{
		Employee emp1 = new Employee();
		emp1.setAdresse("6 rue des Oliviers");
		emp1.setAgency("Mougins");
		emp1.setBirthDate(new Date());
		emp1.setEmail("florian.bougeolet@telecom-bretagne.eu");
		emp1.setName("Florian");
		emp1.setSurname("Bourgeolet");
		emp1.setProfilPicture("pictures/profiles/florian_bourgeolet.png");
		emp1.setTelephone("0685698710");
		
		Employee emp2 = new Employee();
		emp2.setAdresse("6 rue des Pins");
		emp2.setAgency("Mougins");
		emp2.setBirthDate(new Date());
		emp2.setEmail("lise.collomb@telecom-bretagne.eu");
		emp2.setName("Lise");
		emp2.setSurname("Collomb");
		emp2.setProfilPicture("pictures/profiles/lise_collomb.png");
		emp2.setTelephone("0652142089");
		
		List<Employee> team = new ArrayList<Employee>();
		team.add(emp1);
		team.add(emp2);
		
		
		Project project = new Project();
		project.setName("SoFeed");
		project.setInformation("Solution developpée pour la participation au concours Infotel");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		project.setStartDate(formatter.parse("24-avril-2016"));
		
		project.setTeam(team);
		
		Document doc = new Document();
		doc.setName("Compte rendu 1");
		doc.setProject(project);
		doc.setDate(formatter.parse("28-avril-2016"));
		doc.setPath("/doc/sofeed/compte_rendu_1.txt");
		
		Ticket ticket1 = new Ticket();
		ticket1.setDescription("Developpement du service RabbitMQ pour la messagerie instantanee");
		ticket1.setEmployees(team);
		ticket1.setProject(project);
		ticket1.setName("JIRA-1542");
		ticket1.setStartDate(formatter.parse("10-mai-2016"));
		
		Ticket ticket2 = new Ticket();
		ticket2.setDescription("Developpement de l'interface REST");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp2);
		ticket2.setEmployees(employees);
		ticket2.setProject(project);
		ticket2.setName("JIRA-1582");
		ticket2.setStartDate(formatter.parse("5-mai-2016"));
		
		Event event = new Event();
		event.setName("Soiree d'agence");
		event.setDescription("Soirée organisee par l'agence de Mougins et Monaco pour tous les collaborateurs d'Infotel...");
		event.setStartDate(formatter.parse("9-juin-2016"));
		event.setEndDate(formatter.parse("9-juin-2016"));
		event.setType("agence-mougins");
		
		Event event2 = new Event();
		event2.setName("Concours etudiants");
		event2.setDescription("Concours de design d'application");
		event2.setStartDate(formatter.parse("27-mai-2016"));
		event2.setEndDate(formatter.parse("27-mai-2016"));
		event2.setType("concours");
		event2.setParticipants(team);

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		
		session.save(project);
		session.save(event);
		session.save(event2);
		session.save(doc);
		session.save(ticket1);
		session.save(ticket2);
		
		session.getTransaction().commit();
		
		session.close();
		System.out.println("Session Closed");
//		Session session = HibernateUtils.getSession();
//		session.beginTransaction();
//		Project project = new Project();
//		project.setInformation("Voici un autre test");
//		project.setName("test2");
//		project.setStartDate(new Date());
//		Document document = new Document();
//		document.setDate(new Date());
//		document.setName("CP rÃ©u");
//		document.setPath("~/cpreu.txt");
//		Set<Document> documents = new HashSet<Document>();
//		documents.add(document);
//		session.save(project);
//		session.getTransaction().commit();
	}

}
