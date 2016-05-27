package main;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

import bean.Employee;
import bean.Event;
import bean.Ticket;
import client.EmployeeClient;
import client.EventClient;
import client.TicketClient;
import utils.RabbitMQUtils;

public class Main {
	private static final String RPC_QUEUE_NAME = "rpc_queue";
	
	public static void main(String[]args) throws TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException, IOException{
		Channel channel = RabbitMQUtils.getNotificationChannel();
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume("notification", false, consumer);
		
		while(true){
			// we take the next message in the queue
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			
			// we analyse the message
		    BasicProperties props = delivery.getProperties();
		    String message = new String(delivery.getBody());
		    System.out.println(message);
//		    // we try to map the message to a java object and create the object
//		    ObjectMapper mapper = new ObjectMapper();
//		    try {
//				Employee emp = mapper.readValue(message, Employee.class);
//				EmployeeClient.createEmployee(emp);
//			} catch(Exception e){
//		    	
//		    }
//		    
//		    try {
//		    	Event evt = mapper.readValue(message, Event.class);
//		    	EventClient.createEvent(evt);
//		    }
//		    catch(Exception e){
//		    	
//		    }
//		    try {
//		    	Ticket ticket = mapper.readValue(message, Ticket.class);
//		    	TicketClient.createEvent(ticket);
//		    }
//		    catch(Exception e){
//		    	
//		    }
		}
		
	}

}
