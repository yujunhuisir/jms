package spittr;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsOperations;


public class JMSMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("META-INF/spring/messaging.xml");
		JmsOperations jms = cpx.getBean(JmsOperations.class);
		for(int i=0;i<10;i++) {
			jms.convertAndSend("hello queue","Hello");
		}
		cpx.close();
	}
}
