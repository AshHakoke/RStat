package com.example.rstatistic.corpotationIndustry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface CorpIndustryRepository extends JpaRepository<CorpIndustryEntity, Date> {
}
