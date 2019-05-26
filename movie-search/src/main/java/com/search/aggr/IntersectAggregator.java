package com.search.aggr;

import java.util.ArrayList;
import java.util.*;

public class IntersectAggregator implements Aggregator {
    @Override
    public List<String> aggregate(List<Set<String>> results) {
        List<String> result = new ArrayList<>();

        if(results == null || results.size()==0)
            return new ArrayList<>();

        if(results.size()==1)
            return new ArrayList<>(results.get(0));

        for(String val: results.get(0))
        {
            boolean isInall = true;

            for(int i=1; i<results.size(); i++)
            {
                if(!results.get(i).contains(val))
                {
                    isInall=false;
                    break;
                }
            }
            if(isInall)
                result.add(val);
        }
        return result;
    }
}
