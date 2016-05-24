package main;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

import bean.Employee;
import client.EmployeeClient;
import utils.RabbitMQUtils;

public class Main {
	private static final String RPC_QUEUE_NAME = "rpc_queue";
	
	public static void main(String[]args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException{
//		Channel channel = RabbitMQUtils.getRPCChannel();
//		QueueingConsumer consumer = new QueueingConsumer(channel);
//		channel.basicConsume(RPC_QUEUE_NAME, false, consumer);
//		
//		while(true){
//			// we take the next message in the queue
//			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//			
//			// we analyse the message
//		    BasicProperties props = delivery.getProperties();
//		    String message = new String(delivery.getBody());
//		    System.out.println(message);
//		}
		Employee emp = new Employee();
		emp.setName("Test2");
		emp.setSurname("Test");
		EmployeeClient.createEmployee(emp);
		
	}

}
