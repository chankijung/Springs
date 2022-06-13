package com.care.root.config;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class MailService {
	@Autowired JavaMailSender mailSender;

	public void sendMail(String to, String subject, String body) {
		MimeMessage mime =mailSender.createMimeMessage();
		try {
			MimeMessageHelper m = 
					new MimeMessageHelper(mime, true, "UTF-8");
			m.setSubject(subject);
			m.setTo(to);
			m.setText(body);
			mailSender.send(mime);
			
		} catch (Exception e) {
		}
	}

}
