package fr.sofeed.utils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.sofeed.bean.Project;

public class ProjectUtils {
	private static Session session;
	
	public static Project findProjectById(int id){
		session = HibernateUtils.getSession();
		Criteria crit = session.createCriteria(Process.class);
		crit.add(Restrictions.idEq(id));
		if(!crit.list().isEmpty())return (Project)crit.list().get(0);
		else return null;
	}

}
