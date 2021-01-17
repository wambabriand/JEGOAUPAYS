package com.email;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface EmailSenderService {
	
	public boolean sendSimpleMessage(String to, String subject, String text);
    
    public boolean sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
    
    public boolean sendMessageWithAttachment(String to, String subject, String text, List<MultipartFile> pathToAttachment);

}
