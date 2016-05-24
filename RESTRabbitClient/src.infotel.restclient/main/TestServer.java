package main;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.codehaus.jackson.map.ObjectMapper;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;

import bean.Employee;
import utils.RabbitMQUtils;

public class TestServer {
	private String requestQueueName = "rpc_queue";
	private Channel channel;
	
	// on se contente d'envoyer le message
	// on pourrait utiliser le corelationId pour vérifier qu'on reçoit bien une réponse
	// et que le message , n'a été envoyé/reçu une seule fois
	public void call(String message) throws IOException, TimeoutException{
		channel = RabbitMQUtils.getRPCChannel();
		BasicProperties props = new BasicProperties.Builder().build();
		channel.basicPublish("", requestQueueName, props, message.getBytes());
	}
	
	public static void main(String[]args) throws IOException, TimeoutException{
		TestServer t = new TestServer();
		ObjectMapper mapper = new ObjectMapper();
		Employee emp = new Employee();
		emp.setName("TestMQ");
		String message = mapper.writeValueAsString(emp);
		t.call(message);
	}

}
