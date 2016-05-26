package client;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bean.Employee;
import bean.Ticket;
import utils.RestClientUtils;

public class EmployeeClient {
	
	public static void createEmployee(Employee emp){
		Client client = RestClientUtils.getClient();
		WebResource r = client.resource("http://192.168.0.104:8080/infotel/employee");
		ClientResponse response = r.type("application/json").post(ClientResponse.class, emp);
		response.getStatus();
	}
	
	public static void getTicket(){
		Client client = RestClientUtils.getClient();
		WebResource r = client.resource("http://192.168.0.104:8080/infotel/employee/2/ticket/list");
		ClientResponse response = r.accept("application/json").get(ClientResponse.class);
		List<Ticket> tickets = response.getEntity(new GenericType<List<Ticket>>(){});
		response.getStatus();
	}

}
