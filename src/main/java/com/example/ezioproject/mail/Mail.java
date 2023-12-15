package com.example.ezioproject.mail;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Mail 
{


	private static final int BUFFER_SIZE = 4096;

	public int sendPasswordMail(String subject, String emailId, String Employee, String message)
	
	{

		String username = "shubhuchaudhari03@gmail.com";
		String password = "vgso wyea stwt xupe";
			
		 String htmlContent = "<html><body>"
		            + "<h1>Hello, " + Employee + "!</h1>"
		            + "<p>" + message + "</p>"
		            + "<ul>"
		            + "<li>Item 1</li>"
		            + "<li>Item 2</li>"
		            + "<li>Item 3</li>"
		            + "</ul>"
		            + "</body></html>";
		 
		Properties props = new Properties();
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getInstance(props, new javax.mail.Authenticator()
		{
			
			
			
			

			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(emailId));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
			System.out.println("mail " + emailId);
			msg.setSubject(subject);
  
			
			String link = "<a href='http://localhost:8086/login'>click here for go to web page</a>";
			
			
			

			msg.setContent("Name:- " + Employee + "<br>User Email:- " + emailId +"<br>Link :-" + link +"<br>Subject:- "
					+ subject + "<br>Message:- " + message, "text/html");

			Transport.send(msg);

			System.out.println("Done");

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 1;

}


}

