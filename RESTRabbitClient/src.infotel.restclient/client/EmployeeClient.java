package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import bean.Employee;
import utils.RestClientUtils;

public class EmployeeClient {
	
	public static void createEmployee(Employee emp){
		Client client = RestClientUtils.getClient();
		WebResource r = client.resource("http://192.168.0.104:8080/infotel/employee");
		ClientResponse response = r.type("application/json").post(ClientResponse.class, emp);
		response.getStatus();
	}

}
