package com.autoadda.apis.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autoadda.apis.notification.entity.PlatformEmailTemplate;

@Repository
public interface EmailTemplateRepository extends JpaRepository<PlatformEmailTemplate, Integer>{

}
