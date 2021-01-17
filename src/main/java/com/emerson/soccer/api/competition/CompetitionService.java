package com.emerson.soccer.api.competition;

import com.emerson.soccer.api.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> getCompetitions() throws IOException {
        List<Competition> competitions = competitionRepository.getRecords();
        Collections.sort(competitions);

        return competitions;
    }
}
