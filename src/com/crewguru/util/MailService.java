package com.crewguru.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
	
	public static void sendEmail(String toEmailId, String firstName, String password) {
		/*Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");*/
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("crewguruteam","Crewguru10");
				}
			});

		try {

			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vkomuri16@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmailId));
			message.setSubject("Crewguru Account Information");
			message.setText("Dear "+firstName+"," +
					"\n\n Congratulations!!! Your Crewguru account has been created. Below are your credentials."
					+ "\n\n"
					+ "UserId: "+toEmailId
					+"\n\n"
					+ "Password: "+ password
					+"\n\n"
					+" Login :http://localhost:8080/Crewguru/#/login"
					+"\n\n"
					+"Sincerelly,"
					+"\n\n"
					+"Crewguru Team."
					
					);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
