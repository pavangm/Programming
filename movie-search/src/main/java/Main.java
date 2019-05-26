import com.search.WebScrapper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WebScrapper scrapper = new WebScrapper.WebScrapperBuilder().getTopKCrawler(200).build();

        while(true)
        {
            System.out.println("Enter the search term:");
            Scanner scan = new Scanner(System.in);
            String searchTerm = scan.nextLine();//"spielberg"
            System.out.println(scrapper.search(searchTerm));
        }
    }
}
