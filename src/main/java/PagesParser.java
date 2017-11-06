import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class PagesParser extends PageProceeder {
    private static final String URL_CLASS = "g-i-tile-i-title";
    private static final String URL_SELECTOR = "a";

    public static void parseInitialPages(String baseUrl) throws IOException {
        new File("data").mkdirs();

        int numberOfPages = PageCounter.countPages(baseUrl);
        for (int pageNumber = 1; pageNumber < numberOfPages + 1; pageNumber++) {
            String pageUrl = String.format("%spage=%d/", baseUrl, pageNumber);
            parsePages(pageUrl);
        }
    }

    public static void parsePages(String pageUrl) throws IOException {
        Elements tiles = getElements(pageUrl, URL_CLASS, URL_SELECTOR);
        System.out.println(tiles.size());

        for (Element tile : tiles) {
            String link = tile.attr("abs:href") + "comments/";
            ReviewsParser.parseReviews(link);
        }
    }
}
