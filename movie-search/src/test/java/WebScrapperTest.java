import com.search.WebScrapper;
import com.search.parse.Parser;
import com.search.parse.WordLengthParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebScrapperTest {

    @Test
    public void search() {

        WebScrapper scrapper = new WebScrapper.WebScrapperBuilder().getTopKCrawler(50).build();
        String searchTerm = "spielberg";
        System.out.println(scrapper.search(searchTerm));

        searchTerm = "spielberg leonardo";
        System.out.println(scrapper.search(searchTerm));

        WebScrapper scrapper2 = new WebScrapper.WebScrapperBuilder().getTopKCrawler(50).getUnionAggregator().build();
        searchTerm = "spielberg leonardo";
        System.out.println(scrapper2.search(searchTerm));

    }
}