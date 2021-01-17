package com.emerson.soccer.api.repository;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {

    List<T> getRecords() throws IOException;
}
