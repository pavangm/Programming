package com.search.index;
import java.util.*;

public interface Indexer {

    public void updateIndexes(String movie, Set<String> words);

    public Set<String> getIndexMatches(String index);
}
