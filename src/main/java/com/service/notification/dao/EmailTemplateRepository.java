package com.service.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.notification.entity.PlatformEmailTemplate;

@Repository
public interface EmailTemplateRepository extends JpaRepository<PlatformEmailTemplate, Integer>{

}
