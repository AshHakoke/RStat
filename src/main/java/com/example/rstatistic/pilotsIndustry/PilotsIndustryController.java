package com.example.rstatistic.pilotsIndustry;

import com.example.rstatistic.utils.DateRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class PilotsIndustryController {

    private final PilotsIndustryRepository pilotsIndustryRepository;

    @Autowired
    public PilotsIndustryController(PilotsIndustryRepository pilotsIndustryRepository) {
        this.pilotsIndustryRepository = pilotsIndustryRepository;
    }

    @GetMapping("/pilotsindustry")
    public String showUserList(Model model) {

        List<PilotsIndustryEntity> pilots = pilotsIndustryRepository.findAllByEndDateBetweenOrderByIdMainPilotNameAsc(Date.valueOf(LocalDate.now().withDayOfMonth(1)), Date.valueOf(LocalDate.now()));

        List<PilotsIndustrySummaryByName> values = parsePilotsData(pilots);

        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");

        System.out.println(timeColonFormatter.format(LocalDate.now().withDayOfMonth(1)) + " - " + timeColonFormatter.format(LocalDate.now()));
        model.addAttribute("pilots", values);
        model.addAttribute("data",timeColonFormatter.format(LocalDate.now().withDayOfMonth(1)) + " - " + timeColonFormatter.format(LocalDate.now()));
        return "pilotsindustry";
    }

    private List<PilotsIndustrySummaryByName> parsePilotsData(List<PilotsIndustryEntity> pilots) {
        Map<String, PilotsIndustrySummaryByName> data = new HashMap<>();
        for (PilotsIndustryEntity pilot : pilots) {
            if (data.containsKey(pilot.getMainPilotName())) {
                PilotsIndustrySummaryByName temp = data.get(pilot.getMainPilotName());
                temp.refreshWorkersCount(pilot.getWorkersCount());
                temp.refreshDuration(pilot.getIndustryDuration().intValue(), pilot.getMeteDuration().intValue(), pilot.getInventionDuration().intValue(), pilot.getReactionDuration().intValue());
                temp.refreshJobs(pilot.getIndustryJobs().intValue(), pilot.getMeteJobs().intValue(), pilot.getInventionJobs().intValue(), pilot.getReactionJobs().intValue());
            } else {
                PilotsIndustrySummaryByName temp = PilotsIndustrySummaryByName.builder()
                        .mainPilotName(pilot.getMainPilotName())
                        .workersCount(pilot.getWorkersCount())
                        .industryDuration(pilot.getIndustryDuration().intValue())
                        .meteDuration(pilot.getMeteDuration().intValue())
                        .inventionDuration(pilot.getInventionDuration().intValue())
                        .reactionDuration(pilot.getReactionDuration().intValue())
                        .industryJob(pilot.getIndustryJobs().intValue())
                        .inventionJob(pilot.getInventionJobs().intValue())
                        .meteJob(pilot.getMeteJobs().intValue())
                        .reactionJob(pilot.getReactionJobs().intValue())
                        .build();
                data.put(pilot.getMainPilotName(), temp);
            }
        }
        List<PilotsIndustrySummaryByName> values = new ArrayList<>(data.values().stream().toList());
        values.sort(PilotsIndustrySummaryByName.Comparators.DURATION);
        return values;
    }

    @PostMapping("/pilotsindustry")
    public String dateChange(DateRange dateRange, Model model) {
        System.out.println(dateRange.getDateTo()+" "+dateRange.getDateFrom());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(dateRange.getDateFrom())+" "+dateFormat.format(dateRange.getDateTo()));

        List<PilotsIndustryEntity> pilots = pilotsIndustryRepository.findAllByEndDateBetween(
                Date.valueOf(dateFormat.format(dateRange.getDateFrom())),
                Date.valueOf(dateFormat.format(dateRange.getDateTo()))
        );

        List<PilotsIndustrySummaryByName> values = parsePilotsData(pilots);
        model.addAttribute("pilots", values);
        dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        model.addAttribute("data",dateFormat.format(dateRange.getDateFrom()) + " - " + dateFormat.format(dateRange.getDateTo()));
        return "pilotsindustry";
    }

}
