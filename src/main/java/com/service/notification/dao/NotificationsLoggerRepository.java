package com.service.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.notification.entity.NotificationsLogger;

@Repository
public interface NotificationsLoggerRepository extends JpaRepository<NotificationsLogger, Integer>{

}
