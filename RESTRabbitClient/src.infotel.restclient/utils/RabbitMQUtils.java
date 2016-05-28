package utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQUtils {
	private static final String RPC_QUEUE_NAME = "rpc_queue";
	private static Channel RPCChannel;
	private static final String NOTIFICATION_QUEUE_NAME = "notification";
	private static Channel NotificationChannel;
	
	public static Channel getRPCChannel() throws IOException, TimeoutException{
		if (RPCChannel == null){	
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("192.168.1.23");
	
			Connection connection = factory.newConnection();
			RPCChannel = connection.createChannel();
	
			RPCChannel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
	
			RPCChannel.basicQos(1);
		}
		return RPCChannel;
		
	}

	public static Channel getNotificationChannel() throws IOException, TimeoutException {
		if (NotificationChannel == null){	
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("192.168.1.23");
			Connection connection = factory.newConnection();
			NotificationChannel = connection.createChannel();
			NotificationChannel.queueDeclare(NOTIFICATION_QUEUE_NAME, false, false, false, null);
	
			NotificationChannel.basicQos(1);
		}
		return NotificationChannel;
	}
	

}
