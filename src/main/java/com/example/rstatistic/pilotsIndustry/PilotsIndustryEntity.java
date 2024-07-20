package com.example.rstatistic.pilotsIndustry;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "qview_pilots_industry", schema = "seataaa", catalog = "")
public class PilotsIndustryEntity {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "mainPilotName", column = @Column(name = "main_pilot_name")),
            @AttributeOverride(name = "endDate", column = @Column(name = "end_date")),
    })
    private PilotsIndustryCompositeId id;

    @Basic
    @Column(name = "main_pilot_name", insertable=false, updatable=false)
    private String mainPilotName;
    @Basic
    @Column(name = "end_date", insertable=false, updatable=false)
    private Date endDate;
    @Basic
    @Column(name = "workers_count")
    private long workersCount;
    @Basic
    @Column(name = "industry_duration", nullable = true, precision = 0)
    private BigInteger industryDuration;
    @Basic
    @Column(name = "mete_duration", nullable = true, precision = 0)
    private BigInteger meteDuration;
    @Basic
    @Column(name = "invention_duration", nullable = true, precision = 0)
    private BigInteger inventionDuration;
    @Basic
    @Column(name = "reaction_duration", nullable = true, precision = 0)
    private BigInteger reactionDuration;
    @Basic
    @Column(name = "industry_jobs", nullable = true, precision = 0)
    private BigInteger industryJobs;
    @Basic
    @Column(name = "mete_jobs", nullable = true, precision = 0)
    private BigInteger meteJobs;
    @Basic
    @Column(name = "invention_jobs", nullable = true, precision = 0)
    private BigInteger inventionJobs;
    @Basic
    @Column(name = "reaction_jobs", nullable = true, precision = 0)
    private BigInteger reactionJobs;

}
