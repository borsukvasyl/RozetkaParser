import org.jsoup.select.Elements;

import java.io.IOException;

public class PageCounter extends PageProceeder {
    private static final String COUNTER_CLASS = "paginator-catalog-l-link";

    public static int countPages(String pageUrl) throws IOException {
        Elements nums = getElements(pageUrl, COUNTER_CLASS);
        if (nums.size() > 0) {
            return Integer.parseInt(nums.get(nums.size() - 1).text());
        } else {
            return 0;
        }
    }
}
