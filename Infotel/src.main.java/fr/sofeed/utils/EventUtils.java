package fr.sofeed.utils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.sofeed.bean.Event;

public class EventUtils {
	private static Session session;
	
	public static Event findEventById(int id) {
		session = HibernateUtils.getSession();
		Criteria crit = session.createCriteria(Event.class);
		crit.add(Restrictions.idEq(id));
		Event event = (Event)crit.list().get(0);
		return event;
	}

}
