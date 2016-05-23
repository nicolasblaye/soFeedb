package fr.sofeed.utils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.sofeed.bean.Ticket;

public class TicketUtils {
	private static Session session;
	
	public static Ticket findTicketById(int id){
		session = HibernateUtils.getSession();
		Criteria crit = session.createCriteria(Ticket.class);
		crit.add(Restrictions.idEq(id));
		if (!crit.list().isEmpty())return (Ticket)crit.list().get(0);
		else return null;
	}

}
