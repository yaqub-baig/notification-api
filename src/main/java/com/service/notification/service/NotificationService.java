package com.service.notification.service;

import com.service.notification.request.NotificationRequest;
import com.service.notification.response.GenericResponse;


public interface NotificationService {

	GenericResponse sendPlatformEmail(NotificationRequest notificationRequest);

}
