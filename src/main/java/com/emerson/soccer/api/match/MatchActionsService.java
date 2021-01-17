package com.emerson.soccer.api.match;

import com.emerson.soccer.api.repository.MatchActionRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchActionsService {
    private final MatchActionRepository matchActionRepository;

    public MatchActionsService(MatchActionRepository matchActionRepository) {
        this.matchActionRepository = matchActionRepository;
    }

    public MatchActions getActionByMatchId(ResourceId matchId) throws IOException {
        List<MatchActions> records = matchActionRepository.getRecords();

        return records
                .stream()
                .filter(actions -> actions.matchId() == matchId.Value())
                .findFirst()
                .orElse(null);
    }

    public MatchActions getActionByMatchIdFilterByAction(ResourceId matchId, ActionType actionType) throws IOException {
        List<MatchActions> records = matchActionRepository.getRecords();

        MatchActions matchActions = records
                .stream()
                .filter(matchAction -> matchAction.matchId() == matchId.Value())
                .findFirst()
                .orElse(null);

        List<Action> actionsFiltered = matchActions
                .actions()
                .stream()
                .filter(action -> action.type() == actionType)
                .collect(Collectors.toList());

        matchActions.removeActions();
        matchActions.addAll(actionsFiltered);

        return matchActions;
    }
}
