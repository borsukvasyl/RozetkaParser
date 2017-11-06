import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

abstract class PageParser {
    protected static Document getPage(String pageUrl) throws IOException {
        return Jsoup.connect(pageUrl).timeout(0).get();
    }
}
