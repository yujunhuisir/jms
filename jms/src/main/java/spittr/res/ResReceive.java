package spittr.res;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class ResReceive {
	public static void main(String[] args) {
		//连接工厂
				ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
				Connection conn = null;
				Session session = null;
				try {
				conn = connectionFactory.createConnection();
				conn.start();
				session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
				//Destination dest = new ActiveMQQueue("spittr.queue.my");
				Destination dest = new ActiveMQQueue("hello queue");
				MessageConsumer consumer = session.createConsumer(dest);
				Message message = consumer.receive();
				TextMessage textMessage = (TextMessage) message;
				System.out.println("Got a MESSAGE: "+textMessage.getText());
				conn.start();
				}catch(JMSException ex) {
					
					
				}finally{
					try {
						if(session!=null) {
							session.close();
						}
						if(conn!=null) {
							conn.close();
						}
					}catch(JMSException ex) {
						
					}
				}
	}
}
