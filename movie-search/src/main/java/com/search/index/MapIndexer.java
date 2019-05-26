package com.search.index;

import java.util.*;

public class MapIndexer implements Indexer {

    Map<String, Set<String>> keyWordToMap;
    public MapIndexer()
    {
        this.keyWordToMap = new HashMap<>();
    }

    @Override
    public void updateIndexes(String movie, Set<String> words) {
        for(String word: words)
        {
            Set<String> movies = keyWordToMap.getOrDefault(word, new HashSet<>());
            movies.add(movie);
            keyWordToMap.put(word, movies);
        }
    }

    @Override
    public Set<String> getIndexMatches(String index) {
        return keyWordToMap.getOrDefault(index.toLowerCase(), new HashSet<>());
    }
}
