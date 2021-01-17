package com.emerson.soccer.api.match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/match")
public class MatchActionsController {

    private final static Logger logger = LoggerFactory.getLogger(MatchActionsController.class);

    private final MatchActionsService matchActionsService;

    public MatchActionsController(MatchActionsService matchActionsService) {
        this.matchActionsService = matchActionsService;
    }

    @RequestMapping(value = "/{matchId}/actions")
    public MatchActions getActionByMatchId(@PathVariable ResourceId matchId) throws IOException {

        return matchActionsService.getActionByMatchId(matchId);
    }

    @RequestMapping(value = "/{matchId}/action")
    public MatchActions getActionByMatchId(
            @PathVariable ResourceId matchId,
            @RequestParam("action_type") String actionType) throws IOException {

        return matchActionsService.getActionByMatchIdFilterByAction(matchId, ActionType.valueOf(actionType));
    }
}
