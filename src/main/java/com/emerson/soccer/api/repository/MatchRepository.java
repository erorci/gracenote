package com.emerson.soccer.api.repository;

import com.emerson.soccer.api.competition.Competition;
import com.emerson.soccer.api.integration.MatchActionsCSVReader;
import com.emerson.soccer.api.match.Match;
import com.emerson.soccer.api.match.ResourceId;
import com.emerson.soccer.api.match.Summary;
import com.emerson.soccer.api.match.Team;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MatchRepository implements Repository<Match> {

    private final MatchActionsCSVReader csvReader;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MMM-yy");

    public MatchRepository(MatchActionsCSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public List<Match> getRecords() throws IOException {
        Set<Match> matches = new HashSet<>();
        List<List<String>> records = csvReader.getRecords();
        for (List<String> record : records) {
            if (record.get(0).equals("n_ActionID")) {
                continue;
            }

            matches.add(getMatch(record));
        }

        return new ArrayList<>(matches);
    }

    private Match getMatch(List<String> record) {
        ResourceId matchId = ResourceId.of(Long.parseLong(record.get(2))); //c_MatchID

        Summary summary = new Summary(
                Team.withName(record.get(3)), //c_HomeTeam
                Team.withName(record.get(4)), //c_AwayTeam
                Integer.parseInt(record.get(5)), //n_HomeGoals
                Integer.parseInt(record.get(6))); //n_AwayGoals

        return new Match(
                matchId,
                summary,
                LocalDate.parse(record.get(7), dateTimeFormatter),  //d_Date
                Competition.withName(record.get(1))); //c_Competition
    }
}
