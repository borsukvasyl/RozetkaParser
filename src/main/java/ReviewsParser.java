import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ReviewsParser extends PageProceeder {
    private static final String REVIEWS_CLASS = "pp-review-i";
    private static final String REVIEWS_SELECTOR = "article";

    private static final String STARS_CLASS = "g-rating-stars-i";
    private static final String STARS_ATTR = "content";
    private static final String TEXT_CLASS = "pp-review-text-i";

    private static final String REVIEW_FORMAT = "%s, \"%s\"\n";

    public static void parseReviews(String pageUrl) throws IOException {
        int numberOfPages = PageCounter.countPages(pageUrl);
        ArrayList<String> reviews = new ArrayList<String>();

        for (int pageNumber = 0; pageNumber < numberOfPages; pageNumber++) {
            String reviewsPageUrl = String.format("%s/page=%d/", pageUrl, pageNumber);
            reviews.addAll(getReviews(reviewsPageUrl));
        }
        ReviewsWriter.writeReviews(pageUrl, reviews);
        System.out.println(reviews.size() + " from " + pageUrl);
    }

    public static ArrayList<String> getReviews(String pageUrl) throws IOException {
        Elements reviews = getElements(pageUrl, REVIEWS_CLASS, REVIEWS_SELECTOR);

        ArrayList<String> sentiments = new ArrayList<String>();
        for (Element review : reviews) {
            String stars = review.getElementsByClass(STARS_CLASS).attr(STARS_ATTR);
            if (!stars.equals("")) {
                String text = String.format(REVIEW_FORMAT,stars, review.getElementsByClass(TEXT_CLASS).get(0).text());
                sentiments.add(text);
            }
        }
        return sentiments;
    }
}
