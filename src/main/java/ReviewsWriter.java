import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ReviewsWriter {
    public static void writeReviews(String pageUrl, ArrayList<String> reviews) throws FileNotFoundException {
        String filename = "data/" + pageUrl.split("/")[4] + ".csv";
        PrintWriter writer = new PrintWriter(filename);
        for (Object line : reviews) {
            writer.write(line.toString());
        }
        writer.close();
    }
}
