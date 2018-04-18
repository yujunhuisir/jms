package spittr.alerts;

import org.springframework.jms.core.JmsOperations;

import spittr.domain.Spittle;

public class AlertServiceImpl implements AlertService {
	private JmsOperations jmsOperations;
	//@Autowired
	public AlertServiceImpl(JmsOperations jmsOperations) {
		this.jmsOperations = jmsOperations;
	}
	public void sendSpittleAlert(Spittle spittle) {
		jmsOperations.convertAndSend(spittle);
	}

	public Spittle retrieveSpittleAlert() {
		return (Spittle) jmsOperations.receiveAndConvert();
	}

}
