import java.io.IOException;

public class Parse {
    public static void main(String[] args) throws IOException {
        String baseUrl = "https://rozetka.com.ua/ua/usb-flash-memory/c80045/";
        PagesParser.parseInitialPages(baseUrl);
    }
}
