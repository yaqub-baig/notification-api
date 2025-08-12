package com.autoadda.apis.notification.service;

import java.io.StringReader;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateService {
	
	public String getVerifyEmailTemplate(String verifyUrl, String htmlCotent) {
		RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
		StringReader reader = new StringReader(htmlCotent);
		Template template = new Template();
		VelocityContext context = new VelocityContext();
	    context.put("verifyUrl", verifyUrl);
	    StringWriter stringWriter = new StringWriter();
	    try {
	    	template.setRuntimeServices(runtimeServices);
	    	template.setData(runtimeServices.parse(reader, "Car services platform"));
	    	template.initDocument();
			template.merge(context, stringWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return stringWriter.toString();
	}

}
