package com.search;

import com.search.aggr.Aggregator;
import com.search.aggr.IntersectAggregator;
import com.search.aggr.UnionAggregator;
import com.search.crawl.Crawler;
import com.search.crawl.TopKImdbCrawler;
import com.search.index.Indexer;
import com.search.index.MapIndexer;
import com.search.parse.Parser;
import com.search.parse.WordLengthParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.*;

public class WebScrapper {

    Crawler crawler;
    Parser parser;
    Aggregator aggregator;
    Indexer indexer;

    Connection connection;
    private WebScrapper(WebScrapperBuilder builder)
    {
        this.crawler = builder.crawler;
        this.parser = builder.parser;
        this.aggregator = builder.aggregator;
        this.indexer = builder.indexer;
        this.connection = builder.connection;
    }


    public static class WebScrapperBuilder
    {
        Crawler crawler;
        Parser parser;
        Aggregator aggregator;
        Indexer indexer;

        Connection connection;
        public WebScrapperBuilder()
        {
            this.connection = Jsoup.connect("https://www.imdb.com");
            this.crawler = new TopKImdbCrawler(1000, connection);
            this.parser = new WordLengthParser(3, connection);
            this.aggregator = new IntersectAggregator();
            this.indexer = new MapIndexer();
        }

        public WebScrapperBuilder getTopKCrawler(int k) {
            this.crawler = new TopKImdbCrawler(k, connection);
            return this;
        }

        public WebScrapperBuilder getUnionAggregator()
        {
            this.aggregator = new UnionAggregator();
            return this;
        }

        public WebScrapper build()
        {

            System.out.println("Initializating...");

            Map<String, String> movieUrls = this.crawler.crawl();

            System.out.println();
            System.out.print("Parsing movie sites.");

            int i=1;

            for(String movieName: movieUrls.keySet()) {
                Set<String> keyWords = this.parser.parse(movieUrls.get(movieName));
                this.indexer.updateIndexes(movieName, keyWords);
                System.out.print(".");
                i++;
                if(i% 100 == 0)
                    System.out.println("\n" + i + "/1000 complete");
            }
            System.out.println("Initialization complete");

            WebScrapper webScrapper = new WebScrapper(this);
            return webScrapper;
        }
    }

    private Set<String> searchKey(String key)
    {
        return this.indexer.getIndexMatches(key);
    }

    public List<String> search(String keywords)
    {
        Set<String> results = new HashSet<>();

        String[] words = keywords.split("\\s+");

        List<Set<String>> matchedMovies = new ArrayList<>();
        for(String word: words)
        {
            matchedMovies.add(searchKey(word));
        }

        return this.aggregator.aggregate(matchedMovies);
    }

}
