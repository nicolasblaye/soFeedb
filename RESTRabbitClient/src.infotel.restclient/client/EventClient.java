package client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.core.GenericEntity;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bean.Event;
import utils.RabbitMQUtils;
import utils.RestClientUtils;

public class EventClient {
	
	public static void createEvent(Event evt){
		Client client = RestClientUtils.getClient();
		WebResource webResource = client.resource("http://localhost:8080/infotel/event");
		//ClientResponse response = webResource.type("application/json").post(ClientResponse.class, evt);
		try{
			// queue = notification (plus simple, un peu nul...)
			Channel channel = RabbitMQUtils.getNotificationChannel();
			BasicProperties props = new BasicProperties.Builder().build();
			Calendar cal = Calendar.getInstance();
			cal.setTime(evt.getStartDate());
			String message = "Alerte: "+evt.getName()+" le " + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH);
			System.out.println(message);
			System.out.println(channel);
			channel.basicPublish("amq.fanout", "notification", props, message.getBytes());
			System.out.println(channel.messageCount("notification"));
			channel.close();
		}
		catch(Exception e){
			System.out.println("something bad happened");
			e.printStackTrace();
		}
		
	}
	
	public static void getEvent(){
		Client client = RestClientUtils.getClient();
		WebResource r = client.resource("http://localhost:8080/infotel/event/list");
		ClientResponse response = r.type("application/json").get(ClientResponse.class);
		List<Event> events = response.getEntity(new GenericType<List<Event>>(){});
		for (Event e:events){
			System.out.println(e.getDescription());
		}
	}

}
