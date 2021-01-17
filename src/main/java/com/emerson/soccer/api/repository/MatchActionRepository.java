package com.emerson.soccer.api.repository;

import com.emerson.soccer.api.competition.Competition;
import com.emerson.soccer.api.integration.MatchActionsCSVReader;
import com.emerson.soccer.api.match.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchActionRepository implements Repository<MatchActions> {

    private final MatchActionsCSVReader csvReader;

    HashMap<ResourceId, MatchActions> matchDict;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MMM-yy");

    public MatchActionRepository(MatchActionsCSVReader csvReader) {
        this.csvReader = csvReader;
        matchDict = new HashMap<>();
    }

    @Override
    public List<MatchActions> getRecords() throws IOException {

        List<List<String>> records = csvReader.getRecords();
        for (List<String> record : records) {
            if (record.get(0).equals("n_ActionID")) {
                continue;
            }
            ResourceId matchId = ResourceId.of(Long.parseLong(record.get(2))); //c_MatchID

            Match match = getMatch(record, matchId);
            updateMatchAction(record, matchId, match);
        }

        return matchDict.values().stream().collect(Collectors.toList());
    }

    private Match getMatch(List<String> record, ResourceId matchId) {
        Summary summary = new Summary(
                Team.withName(record.get(3)), //c_HomeTeam
                Team.withName(record.get(4)), //c_AwayTeam
                Integer.parseInt(record.get(5)), //n_HomeGoals
                Integer.parseInt(record.get(6))); //n_AwayGoals

        Match match = new Match(
                matchId,
                summary,
                LocalDate.parse(record.get(7), dateTimeFormatter),  //d_Date
                Competition.withName(record.get(1))); //c_Competition

        return match;
    }

    private Action getAction(List<String> record) {
        return new Action(
                ResourceId.of(Long.parseLong(record.get(0))), //c_ActionID
                ActionType.valueOfLabel(record.get(8)),//c_Action
                Period.valueOfLabel(record.get(9)), //c_Period
                Long.parseLong(record.get(10).equals("NULL") ? "0" : record.get(10)), //n_StartTime
                Long.parseLong(record.get(11).equals("NULL") ? "0" : record.get(11)), //n_Endtime
                HomeOrAway.fromValue(Integer.parseInt(record.get(12))), //n_HomeOrAway
                new ActionInvolved(
                        record.get(14).equals("NULL") ? null : Team.withName(record.get(14)), //c_Team
                        record.get(16).equals("NULL") ? null : record.get(16), //c_person
                        record.get(19).equals("NULL") ? null : record.get(19), //c_ActionReason
                        record.get(20).equals("NULL") ? null : record.get(22)) //c_Subperson
        );
    }

    private void updateMatchAction(List<String> record, ResourceId matchId, Match match) {
        MatchActions matchActions = new MatchActions(match);

        if (!matchDict.containsKey(matchId)) {
            matchDict.put(matchId, matchActions);
        }

        MatchActions matchToAddAction = matchDict.get(matchId);
        matchToAddAction.add(getAction(record));

        matchDict.put(matchId, matchToAddAction);
    }
}
