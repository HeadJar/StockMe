import java.util.ArrayList;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//This class is the methods to pull stock data and add it to lists
//Its constructor creates an arraylist to hold the stocks the user wants to look up
public class PullData {

	ArrayList<String> list;
	String ticker;

	public PullData() {
		list = new ArrayList<String>();
		ticker = "";

	}

	public void setTicker(String x) {
		ticker = x;
	}

	public String getTicker() {
		return ticker;
	}

	public String retrieveTickerInfo(String x) throws IOException {
		String url = "https://markets.businessinsider.com/stocks/" + x + "-stock";
		Document doc = Jsoup.connect(url).get();
		Elements data = doc.getElementsByClass("push-data");
		return data.text();

	}

	public void addData(String x) {
		try {
			list.add(retrieveTickerInfo(x));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString() {
		String x = "";
		for (String s : list) {
			x = x + s + "\n";
		}
		return x;
	}

	public static void main(String[] args) throws IOException {
		PullData x = new PullData();
		x.addData("AAPL");
		x.addData("TSLA");
		System.out.println(x.toString());

	}

}
