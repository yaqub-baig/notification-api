package com.service.notification.entity;

import java.util.Date;

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
@Table(name = "notification_logger")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationsLogger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "member_id")
	private Integer memberId;
	
	@Column(name = "member_type")
	private String memberType;
	
	@Column(name = "notification_type")
	private String notificationType;
	
	@Column(name = "note_status")
	private String noteStatus;
	
	@Column(name = "insert_tms")
	private Date insertTms;
	
	@Column(name = "comments")
	private String comments;
}
