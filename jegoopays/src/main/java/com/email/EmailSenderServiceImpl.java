package com.email;

import java.io.File;
import java.util.List;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderServiceImpl implements EmailSenderService{

	 	@Autowired
	    public JavaMailSender emailSender;

	    @Override
	    public boolean sendSimpleMessage(String to, String subject, String text) {
	        try {
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setTo(to);
	            message.setSubject(subject);
	            message.setText(text);

	            emailSender.send(message);
	        } catch (MailException exception) {
	        	System.out.println( exception.getMessage() );
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public boolean sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
	        try {
	            MimeMessage message = emailSender.createMimeMessage();
	            // pass 'true' to the constructor to create a multipart message
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);

	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(text);
	           
	            FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
	            helper.addAttachment("Invoice", file);

	            emailSender.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }

		@Override
		public boolean sendMessageWithAttachment(String to, String subject, String text,
				List<MultipartFile> pathToAttachments) {
			
			try {
				 MimeMessage message = emailSender.createMimeMessage();
		         MimeMessageHelper helper = new MimeMessageHelper(message, true);
		         Multipart multipart = new MimeMultipart();
		         BodyPart messageBodyPart = new MimeBodyPart();
		         
		         helper.setTo(to);
		         helper.setSubject(subject);
	             messageBodyPart.setContent(text, "text/html");
	             multipart.addBodyPart(messageBodyPart);
 
		         for (MultipartFile filePath : pathToAttachments) {
		        	 MimeBodyPart attachPart = new MimeBodyPart();
		        	  
		        	 attachPart.setContent(filePath.getBytes(), filePath.getContentType());
		        	 attachPart.setFileName(filePath.getOriginalFilename());
		        	 attachPart.setDisposition(Part.ATTACHMENT);
		        	 multipart.addBodyPart(attachPart);
	             }
		         message.setContent(multipart);
		         emailSender.send(message);
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
}
