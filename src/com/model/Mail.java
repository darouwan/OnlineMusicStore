package com.model;

import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	private String sendTo;
	private String content;

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean send() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.cse.unsw.edu.au");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("jche143",
								"chenjunfeng");
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("jche143@cse.unsw.edu.au"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(sendTo));
			message.setContent(content, "text/html;charset=utf-8");
			message.setSubject("No Reply: Confirmation Letter");
			// message.setText(content);

			Transport.send(message);

			System.out.println("Mail send successfully");
			return true;
		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			return false;
		}
	}

	public void sendMailTLS() {
		final String username = "jche143@gmail.com";
		final String password = "882496123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("jche143@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(sendTo));
			message.setContent(content, "text/html;charset=utf-8");
			message.setSubject("No Reply: Confirmation Letter");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void sendMailSina() {
		String host = "smtp.sina.com.cn";
		String from = "jche143@sina.com";
		String to = sendTo;
		String username = "jche143@sina.com";
		String password = "chenjunfeng";

		// Get system properties
		// Properties props = System.getProperties();
		// 很多例子中是这样的，其实下面这句更好，可以用在applet中
		Properties props = new Properties();

		// Setup mail server
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true"); // 这样才能通过验证

		// Get session
		Session session = Session.getDefaultInstance(props);

		// watch the mail commands go by to the mail server
		session.setDebug(true);

		// Define message
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setContent(content, "text/html;charset=utf-8");
			message.setSubject("No Reply: Confirmation Letter");

			// Send message
			message.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(host, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
