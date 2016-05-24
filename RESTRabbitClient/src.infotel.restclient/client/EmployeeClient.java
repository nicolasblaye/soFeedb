package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import bean.Employee;

public class EmployeeClient {
	
	public void createEmployee(Employee emp){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/infotel/employee");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, client);
		
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
	}

}
