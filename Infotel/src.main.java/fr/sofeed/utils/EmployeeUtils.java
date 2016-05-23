package fr.sofeed.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.sofeed.bean.Employee;

public class EmployeeUtils {
	private static Session session;
	
	public static Employee findEmployeeById(int id) {
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

}
