package com.search.parse;

import java.util.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WordLengthParser implements Parser {

    /*
    This class extracts all the keywords for the movie based on StringLength of atleast 4
    at some key sections in the imdb movie title website.
     */

    int k;

    Connection connection;

    public WordLengthParser(int k, Connection connection)
    {
        this.k = k;
        this.connection = connection;
    }

    @Override
    public Set<String> parse(String url) {
        Set<String> result = new HashSet<>();

        try {
            this.connection.url(url);

            Document document = this.connection.get();

            //"div#titleCast.article"

            String[] cssQueries=
                    {"div.plot_summary div.credit_summary_item a"
                            };

            for(String query: cssQueries) {
                String[] content = document.select(query).text().split("\\s+");

                for (String keyword : content) {
                    keyword = keyword.replaceAll("[^\\w+]", "");
                    if (keyword.length() >= k) {
                        result.add(keyword.toLowerCase());
                    }
                }
            }
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
        return result;
    }
}
