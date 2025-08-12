package com.autoadda.apis.notification.service;

import com.autoadda.apis.notification.request.NotificationRequest;
import com.autoadda.apis.notification.response.GenericResponse;


public interface NotificationService {

	GenericResponse sendPlatformEmail(NotificationRequest notificationRequest);

}
