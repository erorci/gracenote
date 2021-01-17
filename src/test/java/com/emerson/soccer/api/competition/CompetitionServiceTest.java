package com.emerson.soccer.api.competition;

import com.emerson.soccer.api.repository.CompetitionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CompetitionServiceTest {

    @MockBean
    private CompetitionRepository repository;

    @Autowired
    private CompetitionService service;

    @Test
    public void shouldReturnAListOfCompetitionOrderedByName() throws Exception {
        given(repository.getRecords())
                .willReturn(new ArrayList<>(Arrays.asList(
                        Competition.withName("Italian Serie A"),
                        Competition.withName("Brazil Serie A"),
                        Competition.withName("Dutch Eredivisie")))
                );

        List<Competition> competitionsOrdered = new ArrayList<>(Arrays.asList(
                Competition.withName("Brazil Serie A"),
                Competition.withName("Dutch Eredivisie"),
                Competition.withName("Italian Serie A")));

        List<Competition> competitions = service.getCompetitions();

        assertThat(competitions).isEqualTo(competitionsOrdered);
    }
}
