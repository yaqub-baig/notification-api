package com.platform.notification.service;

import com.platform.notification.request.NotificationRequest;
import com.platform.notification.response.GenericResponse;


public interface PlatformNotificationService {

	GenericResponse sendPlatformEmail(NotificationRequest notificationRequest);

}
