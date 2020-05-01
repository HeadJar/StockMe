
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupFromStringEx {

    public static void main(String[] args) throws IOException {
    	
    	
    	

        String ticker = "aapl";

        String url = "https://markets.businessinsider.com/stocks/" + ticker + "-stock";

        Document doc = Jsoup.connect(url).get();


        Elements outerDiv = doc.getElementsByClass("push-data");


        String title = doc.title();
        System.out.println(title);

        String html  = Jsoup.connect(url).get().html();


        System.out.println(outerDiv.text());

        //System.out.println(html);

    }
}
