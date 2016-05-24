package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import bean.Ticket;
import utils.RestClientUtils;

public class TicketClient {
	
	public static void createEvent(Ticket ticket){
		Client client = RestClientUtils.getClient();
		WebResource webResource = client.resource("http://localhost:8080/infotel/ticket");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, ticket);
		
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
		//TODO send notification to the right queue rabbitMQ
		// loop on employee
		// queue = ticket-employee_id
		
	}

}
