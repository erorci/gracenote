package com.emerson.soccer.api.repository;

import com.emerson.soccer.api.competition.Competition;
import com.emerson.soccer.api.integration.MatchActionsCSVReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CompetitionRepository implements Repository<Competition> {

    private final MatchActionsCSVReader csvReader;

    public CompetitionRepository(MatchActionsCSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public List<Competition> getRecords() throws IOException {

        Set<Competition> competitions = new HashSet<>();

        List<List<String>> records = csvReader.getRecords();
        for (List<String> record : records) {
            if (record.get(0).equals("n_ActionID")) {
                continue;
            }
            competitions.add(Competition.withName(record.get(1)));
        }

        return new ArrayList<>(competitions);
    }
}
