import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupFromStringEx {

    public static void main(String[] args) throws IOException {

        String ticker = "AAPL";

        String url = "https://finance.yahoo.com/quote/" + ticker+ "?p=" + ticker + "&.tsrc=fin-srch";

        Document doc = Jsoup.connect(url).get();


        Elements outerDiv = doc.select("div.trendDown2");


        String title = doc.title();
        System.out.println(title);

        String html  = Jsoup.connect(url).get().html();


        System.out.println(outerDiv.text());

        //System.out.println(html);

    }
}