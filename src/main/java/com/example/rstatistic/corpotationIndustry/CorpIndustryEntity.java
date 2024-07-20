package com.example.rstatistic.corpotationIndustry;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "qview_corp_industry_statistics", schema = "seataaa")
public class CorpIndustryEntity {
    @Id
    @Column(name = "end_date", nullable = true)
    private Date endDate;
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

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setIndustryDuration(BigInteger industryDuration) {
        this.industryDuration = industryDuration;
    }

    public void setMeteDuration(BigInteger meteDuration) {
        this.meteDuration = meteDuration;
    }

    public void setInventionDuration(BigInteger inventionDuration) {
        this.inventionDuration = inventionDuration;
    }

    public void setReactionDuration(BigInteger reactionDuration) {
        this.reactionDuration = reactionDuration;
    }

    public int getDurationSummary(){
        return industryDuration.intValue()+meteDuration.intValue()+reactionDuration.intValue()+inventionDuration.intValue();
    }

}
