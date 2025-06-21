package com.platform.notification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "platform_email_template")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlatformEmailTemplate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "template_id")
	private Integer templateId;
	
	@Column(name = "template_type")
	private String templateType;
	
	@Column(name = "temp_desc")
	private String desc;
	
	@Column(name = "content")
	private String content;
	
}
