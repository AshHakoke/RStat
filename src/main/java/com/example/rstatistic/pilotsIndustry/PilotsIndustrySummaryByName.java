package com.example.rstatistic.pilotsIndustry;

import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"mainPilotName"})
public class PilotsIndustrySummaryByName {

    private String mainPilotName;
    private long workersCount;
    private int industryJob;
    private int meteJob;
    private int inventionJob;
    private int reactionJob;
    private int averageDuration = 0;
    private int industryDuration;
    private int meteDuration;
    private int reactionDuration;
    private int inventionDuration;

    public void refreshJobs(int industryJob, int meteJob, int inventionJob, int reactionJob) {
        this.industryJob += industryJob;
        this.meteJob += meteJob;
        this.inventionJob += inventionJob;
        this.reactionJob += reactionJob;

        if (getDurationSummary() > 0 && getJobsSummary() > 0) {
            averageDuration = getDurationSummary() / getJobsSummary();
        }
    }

    public int getJobsSummary() {
        return industryJob+meteJob+reactionJob+inventionJob;
    }

    public int getDurationSummary() {
        return industryDuration+meteDuration+reactionDuration+inventionDuration;
    }

    public void refreshWorkersCount(long workersCount) {
        this.workersCount = Math.max(workersCount, this.workersCount);
    }

    public void refreshDuration(int industryDuration, int meteDuration, int inventionDuration, int reactionDuration) {
        this.industryDuration += industryDuration;
        this.meteDuration += meteDuration;
        this.inventionDuration += inventionDuration;
        this.reactionDuration += reactionDuration;
        
        if (getDurationSummary() > 0 && getJobsSummary() > 0) {
            averageDuration = getDurationSummary() / getJobsSummary();
        }
    }

    public static class Comparators {
        public static final Comparator<PilotsIndustrySummaryByName> NAME = Comparator.comparing((PilotsIndustrySummaryByName o) -> o.mainPilotName);
        public static final Comparator<PilotsIndustrySummaryByName> DURATION = Comparator.comparingInt(PilotsIndustrySummaryByName::getDurationSummary).reversed();
//        public static final Comparator<Student> NAMEANDAGE = (Student o1, Student o2) -> NAME.thenComparing(AGE).compare(o1, o2);
    }
}

