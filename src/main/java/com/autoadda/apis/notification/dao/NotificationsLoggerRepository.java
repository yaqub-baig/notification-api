package com.autoadda.apis.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autoadda.apis.notification.entity.NotificationsLogger;

@Repository
public interface NotificationsLoggerRepository extends JpaRepository<NotificationsLogger, Integer>{

}
