package com.emerson.soccer.api.match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    private final static Logger logger = LoggerFactory.getLogger(MatchController.class);

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping(params = {"competition_name"})
    public List<Match> getMatchesByCompetition(@RequestParam("competition_name") String competitionName) throws IOException {

        return matchService.getAllMatchesByCompetition(competitionName);
    }
}
