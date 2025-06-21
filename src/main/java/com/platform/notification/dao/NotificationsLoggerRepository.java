package com.platform.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.notification.entity.NotificationsLogger;

@Repository
public interface NotificationsLoggerRepository extends JpaRepository<NotificationsLogger, Integer>{

}
