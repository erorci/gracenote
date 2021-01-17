package com.emerson.soccer.api.match;

import com.emerson.soccer.api.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatchesByCompetition(String competitionName) throws IOException {
        List<Match> matches = matchRepository.getRecords();

        return matches
                .stream()
                .filter(match ->
                        match.competitionName()
                                .equals(competitionName))
                .collect(Collectors.toList());
    }
}
