package com.platform.notification.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.notification.dao.NotificationsLoggerRepository;
import com.platform.notification.dao.PlatformEmailTemplateRepository;
import com.platform.notification.entity.NotificationsLogger;
import com.platform.notification.entity.PlatformEmailTemplate;
import com.platform.notification.request.NotificationRequest;
import com.platform.notification.response.GenericResponse;
import com.platform.notification.service.EmailTemplateService;
import com.platform.notification.service.PlatformEmailSender;
import com.platform.notification.service.PlatformNotificationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlatformNotificationServiceImpl implements PlatformNotificationService{
	
	@Autowired
	private PlatformEmailSender platformEmailSender;
	
	@Autowired
	private NotificationsLoggerRepository notificationsLoggerRepository;
	
	@Autowired
	private EmailTemplateService emailTemplateService;
	
	@Autowired
	private PlatformEmailTemplateRepository platformEmailTemplateRepository;

	@Override
	public GenericResponse sendPlatformEmail(NotificationRequest notificationRequest) {
		try {
			PlatformEmailTemplate template = platformEmailTemplateRepository.findAll().get(0);
			String emailContent = emailTemplateService.getVerifyEmailTemplate(notificationRequest.getVerifyUrl(), template.getContent());
			platformEmailSender.sendEmail(notificationRequest.getToEmailId(), emailContent, "Veirify email");
			NotificationsLogger noteLogger = prepareNotificationLogger(notificationRequest);
			notificationsLoggerRepository.save(noteLogger);
			return GenericResponse.builder().status("success").code("200").message("success").build();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while sending the email -> "+notificationRequest.getMemberId());
		}
		return GenericResponse.builder().status("failed").code("500").message("Failed to send email..!").build();
	}

	private NotificationsLogger prepareNotificationLogger(NotificationRequest notificationRequest) {
		return NotificationsLogger.builder()
				.memberId(notificationRequest.getMemberId())
				.insertTms(new Date())
				.memberType(notificationRequest.getMemberType())
				.notificationType("VERIFY_EMAIL")
				.noteStatus("SENT")
				.comments("test")
				.build();
	}

}
