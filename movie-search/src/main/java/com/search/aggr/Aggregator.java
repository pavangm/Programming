package com.search.aggr;

import java.util.*;

public interface Aggregator {
    List<String> aggregate(List<Set<String>> results);
}
