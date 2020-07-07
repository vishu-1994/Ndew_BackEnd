package com.ndew.work.util;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailUtil {
	
	private static Logger log = LogManager.getLogger("Utils_logger");

	public void postMail(String fromAddr,String recipientsTo[],String subject,String hostAddr,String body,String attachFiles[]) {
		
		try {
			
			//set the host smtp
			Properties props = new Properties();
			props.put("mail.smtp.host", hostAddr);
			
			//to resolve the host error from stackoverflow
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		    props.setProperty("mail.smtp.socketFactory.fallback", "false");
		    props.setProperty("mail.smtp.port", "587");
		    props.setProperty("mail.smtp.socketFactory.port", "587");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.debug", "true");
		    props.put("mail.store.protocol", "pop3");
		    props.put("mail.transport.protocol", "smtp");
			
			
			//create default session
			//Session session = Session.getDefaultInstance(props, null);
			
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication("vishudhiman1994@gmail.com", "919410758286");
			    }
			});
			
			session.setDebug(false);
			
			//create a message
			Message msg = new MimeMessage(session);
			
			//set the from address
			InternetAddress addressFrom = new InternetAddress(fromAddr);
			msg.setFrom(addressFrom);  
			log.info("______from : "+fromAddr);
			
			//set the to address
			InternetAddress[] addressTo = new InternetAddress[recipientsTo.length];
			for(int i=0;i<recipientsTo.length;i++) {
				addressTo[i] = new InternetAddress(recipientsTo[i]);
				log.info("_____to : "+recipientsTo[i]);
			}
			
			msg.setRecipients(Message.RecipientType.TO,addressTo);
			
			//set the subject
			msg.setSubject(subject);
			log.info("_____subject : "+subject);
			
			//set the sent date
			msg.setSentDate(new Date());
			
			//create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			
			//set the message
			messageBodyPart.setText(body);
			
			//create a multipart message
			Multipart multipart = new MimeMultipart();
			
			//set text message part
			multipart.addBodyPart(messageBodyPart);
			
			//set the attachments
			for(String filepath:attachFiles) {
				
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filepath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				
				//extracting file name
				String filename = filepath.substring(filepath.indexOf("/")+1,filepath.length());
				log.info("_____filename : "+filename);
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
				
			}
			
			msg.addHeader("myHeaderName","myHeaderValue");
			
			//set the complete message parts
			msg.setContent(multipart);
			
			//send Message
			Transport.send(msg);
			log.info("_____email sent to : "+hostAddr);
			log.info("_____mail sent successfully");
		}catch(Exception me) {
			log.error(me,me);
			
		}
		
	}
}
