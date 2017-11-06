import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

abstract class PageProceeder extends PageParser {
    protected static Elements getElements(String pageUrl, String elementsClass)
            throws IOException {
        Document page = getPage(pageUrl);
        return page.getElementsByClass(elementsClass);
    }

    protected static Elements getElements(String pageUrl, String elementsClass, String elementsSelector)
            throws IOException {
        return getElements(pageUrl, elementsClass).select(elementsSelector);
    }
}
