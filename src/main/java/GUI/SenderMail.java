package GUI;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SenderMail {

	private String mailOrigem;
	private String texto;
	private String systemMail = "es2g26@gmail.com";
	private String systemPw = "engenheriasoftware";

	public SenderMail(String mailOrigem, String texto) {
		this.mailOrigem = mailOrigem;
		this.texto = texto;
	}

	public void sendNow() {
		// Recipient's email ID needs to be mentioned.
		String to = "es2g26@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = mailOrigem;

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = new Properties();

		// Setup mail server
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		//properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(systemMail, systemPw);
			}
		});

		try {

			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(systemMail));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("User: " + from + " sent you a message");

			// Now set the actual message
			message.setText(texto);

			// message.setText("This is actual message");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
