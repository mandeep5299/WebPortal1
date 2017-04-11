package com.wipro.portal.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * @author Prasad
 *
 */
public class MailUtil {

	public void sendMail(String host, String from, String[] to, String subject, String body ) throws AddressException,
			MessagingException {
		// Get system properties
		Properties props = System.getProperties();

		// Setup mail server
		props.put("mail.smtp.host", host);

		// Get session
		Session session = Session.getInstance(props, null);

		// Define message
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.BCC, from);

		InternetAddress[] toAddress = new InternetAddress[to.length];
		for (int i = 0; i < to.length; i++)
			toAddress[i] = new InternetAddress(to[i]);
		message.setRecipients(Message.RecipientType.TO, toAddress);

		message.setSubject(subject);

		// create the message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		
		body +="<br></br>";
		// fill message
		//start
		//messageBodyPart.setContent(body,"text/html");
		messageBodyPart.setContent(body,"text/html; charset=utf-8");
		//end

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment
		/*if(fileAttachment != null && fileAttachment.length>0){
			for (int i = 0; i < fileAttachment.length; i++) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(fileAttachment[i]);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(fileAttachment[i]
						.substring(fileAttachment[i].lastIndexOf("/") + 1));
				multipart.addBodyPart(messageBodyPart);
			}	
		}*/
		

		// Put parts in message
		message.setContent(multipart,"text/html");

		// Send the message
		try {
			Transport.send(message);
		} catch (SendFailedException sfe) {
			sfe.printStackTrace();
			message.setRecipients(Message.RecipientType.TO, sfe
					.getValidUnsentAddresses());
			Transport.send(message);
		}

	}

	public static void main(String args[]) throws Exception {
		String host = "relay.apple.com";
		String from = "ccdisputerequest@group.apple.com";
		String to[] = { "arune.in@gmail.com" };
		String fileAttachment[] = { "/Users/Prasad/Desktop/Amex_europe_valid_MID" };
		new MailUtil().sendMail(host, from, to, "Test", "<font color=\"red\">Hi</font>,\n <b>How are you doing</b>.\n\nThanks,\nPrasad");
	}
}
