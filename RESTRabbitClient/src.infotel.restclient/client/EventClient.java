package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import bean.Event;
import utils.RestClientUtils;

public class EventClient {
	
	public static void createEvent(Event evt){
		Client client = RestClientUtils.getClient();
		WebResource webResource = client.resource("http://localhost:8080/infotel/event");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, evt);
		
		//TODO send notification to the right queue rabbitMQ
		// queue = event-type-agency
		
	}

}
