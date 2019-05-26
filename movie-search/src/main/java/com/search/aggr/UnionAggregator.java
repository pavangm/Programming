package com.search.aggr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UnionAggregator implements Aggregator {
    @Override
    public List<String> aggregate(List<Set<String>> results) {
        List<String> result = new ArrayList<>();

        if(results == null || results.size()==0)
            return new ArrayList<>();

        if(results.size()==1)
            return new ArrayList<>(results.get(0));

        for(int i=1; i<results.size(); i++)
        {
            results.get(0).addAll(results.get(i));
        }

        return new ArrayList<>(results.get(0));
    }
}
