package fr.sofeed.test;

import java.util.Date;

import fr.sofeed.bean.Employee;

public class TestCreate {
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
		
		
	}

}
