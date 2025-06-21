package com.platform.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.notification.entity.PlatformEmailTemplate;

@Repository
public interface PlatformEmailTemplateRepository extends JpaRepository<PlatformEmailTemplate, Integer>{

}
