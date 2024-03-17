package com.example.rstatistic;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PilotsIndustryCompositeId implements Serializable {
    private String mainPilotName;
    private Date endDate;
}
