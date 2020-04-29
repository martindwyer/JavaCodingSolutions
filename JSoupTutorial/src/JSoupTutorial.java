
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupTutorial {

	public static void main(String[] args) throws IOException {

		System.out.println("Trying to get data");
		Document doc = Jsoup.connect("https://www.bestbuy.com/site/westinghouse-49-class-led-1080p-hdtv/6295040.p?skuId=6295040").get();
		String title = doc.title();
		
		System.out.println("title is: " + title);
		
		Elements divElements = doc.select("div.priceView-hero-price.priceView-customer-price");
		System.out.println("Selected div");
		for(Element div : divElements)
		    System.out.println(div);
	}
}
