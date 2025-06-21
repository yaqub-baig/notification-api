package com.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.notification.request.NotificationRequest;
import com.platform.notification.response.GenericResponse;
import com.platform.notification.service.PlatformNotificationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("notification")
public class PlatformNotificationController {
	
	@Autowired
	private PlatformNotificationService platformNotificationService;
	
	
	@Operation(summary = "Sending veiry email with html content")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "successfull email delivery", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = GenericResponse .class)) }),
	  @ApiResponse(responseCode = "404", description = "sendPlatformEmail api not found", 
	    content = @Content) })
	@PostMapping("send")
	public GenericResponse sendPlatformEmail(@RequestBody NotificationRequest notificationRequest) {
		GenericResponse reponse = platformNotificationService.sendPlatformEmail(notificationRequest);
		return reponse;
	}

}
