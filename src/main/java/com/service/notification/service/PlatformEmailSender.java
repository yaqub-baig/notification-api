package com.service.notification.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlatformEmailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmailId, String content, String subject) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(content, true);
            helper.setTo(toEmailId);
            helper.setSubject(subject);
            helper.setFrom("test@email.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Failed to send email for: " + content + "\n" + e);
            throw new IllegalArgumentException("Failed to send email for: " + content);
        }
    }

}
