# Code Structure and project details

Code can be been divided into 4 parts. 
1)	Crawler : This part of the code takes care of fetching the required movie links to be parsed. 
2)	Parser: This part is responsible for fetching the relavant keywords for the movie site.
3)	Indexer: This part is responsible for Indexing the results generated from parser. 
4)	Aggregator: This part takes care of combining results from multiple key words in the search query. 
5)	WebScrapper and WebScrappe Builder: This part of the code integrates above four parts and builds the in-memory data store which will return the movie names associated with search terms. 
The project uses Builder Design Pattern. This pattern helps to choose various implementations of Crawler, Parser, Indexer and Aggregator and returns the WebScrapper object upon calling build method. 

## Crawler: (com.search.crawl.*)
There are two files. 
1) Interface : Crawler 
2) Class: TopKImdbCrawler. 
This class helps to configure website for top k movie sites. These helps for testing the program quickly and run test cases and verify the results. Default setting of 1000 is used by WebScrapperBuilder. 
Parser: (com.search.parse.*)
There are two files.
1)	Interface: Parser
2)	Class: WordLengthParser
This class processes keywords in Imdb movie title link. For simplicity only main cast and director information is processed. WordLengthParser processes the words which are atleast k length. 

## Indexer: (com.search.index.*)
There are two files.
1)	Interface: Indexer
2)	Class: Map Indexer
This class indexes the search results for the movie and indexes all the keywords generated from parser to the movie name using Map data structure. Since, the scope of project is limited, map is used. Trie would be a better data structure handle memory for future enhancements. 

## Aggregator: (com.search.aggr.*)
There are 3 files. 
1)	Interface: Aggregator
2)	Class: IntersectAggregator
3)	Class: UnionAggregator
The class files handle the algorithm to combine the search results from multiple words in the search query string. Example: IntersectAggregator when used will return the movies that contain both Spielberg and Leonardo for search term “spielberg leonardo”. When UnionAggregator is used the scraper will return movies that associated with either Spielberg or Leonardo. 
Builder design pattern can be used when customizing the scrapper. 
Example code snippet: 
WebScrapper scrapper2 = new WebScrapper.WebScrapperBuilder().getTopKCrawler(50).getUnionAggregator().build();

# Future Enhancements
1)	We can use part of speech tagging and advanced Natural Language processing techniques to extract relevant keywords instead of depending on particular location inside title page. Example, We can extract all the proper nouns from the website. This will enhancement for Parser. 
2)	In Memory store used by MapIndexer can be enhanced to use Trie and can be stored in distributed memory data store to increase fault tolerance and reliability for search queries. 
3)	We can also build ranking and increase relevance for search results by enhancing Aggregator. 

## Build Instructions

$ set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_25

$ mvn clean package

#### Executing jar file
$ cd target

$ java -jar movie-search-1.0-SNAPSHOT.jar

