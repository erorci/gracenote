package com.emerson.soccer.api.competition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    private final static Logger logger = LoggerFactory.getLogger(CompetitionController.class);
    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<Competition> getCompetitions() throws IOException {
        return competitionService.getCompetitions();
    }
}
