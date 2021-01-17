package com.emerson.soccer.api.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MatchActionsCSVReader implements MatchActionsReader {

    private static final String COMMA_DELIMITER = ",";

    @Value("${file.path}")
    private String file;

    @Override
    public List<List<String>> getRecords() throws IOException {
        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }

        return records;
    }
}
