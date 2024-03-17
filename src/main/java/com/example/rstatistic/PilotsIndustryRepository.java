package com.example.rstatistic;

import java.sql.Date;
import java.util.List;

public interface PilotsIndustryRepository extends ViewRepository<PilotsIndustryEntity, PilotsIndustryCompositeId> {
    List<PilotsIndustryEntity> findByIdMainPilotName(String mainPilotName);
    List<PilotsIndustryEntity> findAllByEndDateBetweenOrderByIdMainPilotNameAsc(Date endDate, Date endDate2);

    List<PilotsIndustryEntity> findAllByEndDateBetween(Date date, Date date1);
}
