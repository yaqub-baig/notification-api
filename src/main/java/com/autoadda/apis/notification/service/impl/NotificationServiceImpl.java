package com.autoadda.apis.notification.service.impl;

import com.autoadda.apis.notification.dao.NotificationsLoggerRepository;
import com.autoadda.apis.notification.dao.EmailTemplateRepository;
import com.autoadda.apis.notification.entity.NotificationsLogger;
import com.autoadda.apis.notification.entity.PlatformEmailTemplate;
import com.autoadda.apis.notification.request.NotificationRequest;
import com.autoadda.apis.notification.response.GenericResponse;
import com.autoadda.apis.notification.service.EmailTemplateService;
import com.autoadda.apis.notification.service.PlatformEmailSender;
import com.autoadda.apis.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final PlatformEmailSender platformEmailSender;
	private final NotificationsLoggerRepository notificationsLoggerRepository;
    private final EmailTemplateService emailTemplateService;
    private final EmailTemplateRepository platformEmailTemplateRepository;

    @Override
    public GenericResponse sendPlatformEmail(NotificationRequest notificationRequest) {

            PlatformEmailTemplate template = platformEmailTemplateRepository.findAll ( ).get ( 0 );
            String emailContent = emailTemplateService.getVerifyEmailTemplate ( notificationRequest.getVerifyUrl ( ), template.getContent ( ) );
            platformEmailSender.sendEmail ( notificationRequest.getToEmailId ( ), emailContent, "Veirify email" );
            NotificationsLogger noteLogger = prepareNotificationLogger ( notificationRequest );
            notificationsLoggerRepository.save ( noteLogger );
            return GenericResponse.builder ( ).status ( "success" ).code ( "200" ).message ( "success" ).build ( );

    }

    private NotificationsLogger prepareNotificationLogger(NotificationRequest notificationRequest) {
        return NotificationsLogger.builder ( )
                .memberId ( notificationRequest.getMemberId ( ) )
                .insertTms ( new Date ( ) )
                .memberType ( notificationRequest.getMemberType ( ) )
                .notificationType ( "VERIFY_EMAIL" )
                .noteStatus ( "SENT" )
                .comments ( "test" )
                .build ( );
    }

}
