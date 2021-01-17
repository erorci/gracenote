package com.emerson.soccer.api.integration;

import java.io.IOException;
import java.util.List;

public interface MatchActionsReader {
    List<List<String>> getRecords() throws IOException;
}
