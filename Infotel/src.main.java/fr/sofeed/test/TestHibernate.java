package fr.sofeed.test;


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
	
	public static void main(String[]args){
		Employee emp = new Employee();
		emp.setAdresse("Les Oliviers");
		emp.setAgency("Mougins");
		emp.setBirthDate(new Date());
		emp.setEmail("email@telecom.com");
		emp.setName("Florian");
		emp.setSurname("BouBou");
		emp.setProfilPicture("./test");
		emp.setTelephone("00000");
		
		
		Project project1 = new Project();
		project1.setName("test1");
		
		
		List<Employee> team = new ArrayList<Employee>();
		team.add(emp);
		project1.setTeam(team);
		
//		Document doc = new Document();
//		doc.setName("Un doc");
//		List<Document>documents = new ArrayList<Document>();
//		documents.add(doc);
//		project1.setDocuments(documents);
		
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.save(project1);
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
//		document.setName("CP réu");
//		document.setPath("~/cpreu.txt");
//		Set<Document> documents = new HashSet<Document>();
//		documents.add(document);
//		session.save(project);
//		session.getTransaction().commit();
	}

}
