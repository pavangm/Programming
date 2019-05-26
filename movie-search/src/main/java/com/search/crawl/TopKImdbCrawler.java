package com.search.crawl;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TopKImdbCrawler implements Crawler {

    String searchUrl;
    String baseUrl;
    int k;
    Connection connection;

    public TopKImdbCrawler(int k, Connection connection)
    {
        this.connection = connection;
        this.k = k;
        this.baseUrl = "https://www.imdb.com";
        this.searchUrl = "https://www.imdb.com/search/title?groups=top_" + 1000 + "&sort=user_rating&view=simple&count=50";
    }

    public Map<String, String> crawl() {

        Map<String, String> results = new HashMap<>();

        try {
            System.out.print("Started fetching movie Links..");
            for(int i=1; i<=k; i+=50) {
                this.connection.url(this.searchUrl + "&start=" + i);
                Document doc = this.connection.get();


                Elements links = doc.select("div.lister-list div.col-title");
                for (Element ele : links) {
                    Element link = ele.select("a[href^=/title]").first();
                    String movieUrl = this.baseUrl + link.attr("href");
                    String movieName = link.text();
                    results.put(movieName, movieUrl);
                }
                System.out.print(".");
            }
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return results;
    }
}
