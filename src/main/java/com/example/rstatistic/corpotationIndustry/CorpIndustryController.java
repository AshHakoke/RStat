package com.example.rstatistic.corpotationIndustry;

import com.example.rstatistic.pilotsIndustry.PilotsIndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CorpIndustryController {
    private final CorpIndustryRepository corpIndustryRepository;

    @Autowired
    public CorpIndustryController(CorpIndustryRepository corpIndustryRepository) {
        this.corpIndustryRepository = corpIndustryRepository;
    }
    @GetMapping("/corpindustry")
    public String showUserList(Model model) {
        System.out.println(corpIndustryRepository.findAll().size());
        return "corpindustry";
    }

}
