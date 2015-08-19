package JsoapTesting;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupTest {
	static Logger log = Logger.getLogger(JsoupTest.class);

	public static void main(String[] args) throws IOException {
		HtmlCleaner cleaner = new HtmlCleaner();
		CleanerProperties props = new CleanerProperties();
		// set some properties to non-default values
		props.setTranslateSpecialEntities(true);
		props.setTransResCharsToNCR(true);
		props.setOmitComments(true);

		java.util.Date Date = new java.util.Date();
		Timestamp date = (new Timestamp(Date.getTime()));
		log.debug("Processing,please wait...");

		log.info("Creating file...");
		File sportFile = new File("src/main/java/JsoapTesting.File/ " + date
				+ " /sportFile.txt");
		File techFile = new File("src/main/java/JsoapTesting.File/ " + date
				+ " /techFile.txt");
		File businessFile = new File("src/main/java/JsoapTesting.File/ " + date
				+ " /businessFile.txt");
		File fitnessFile = new File("src/main/java/JsoapTesting.File/ " + date
				+ " /fitnessFile.txt");
		File travelFile = new File("src/main/java/JsoapTesting.File/ " + date
				+ " /travelFile.txt");

		log.info("Establish the connection to the theStar...");

		Document travelDoc = Jsoup
				.connect("http://www.thestar.com.my/RSS/Travel/Malaysia/")
				.userAgent("Mozilla").get(); // connect to theStar travel
		Document sportDoc = Jsoup
				.connect("http://www.thestar.com.my/RSS/Sport/Football/")
				.userAgent("Mozilla").get(); // connect to theStar sport
		Document fitnessDoc = Jsoup
				.connect(
						"http://www.thestar.com.my/RSS/Lifestyle/Health/Fitness/")
				.userAgent("Mozilla").get(); // connect to theStar fitness
		Document techDoc = Jsoup
				.connect("http://www.thestar.com.my/RSS/Tech/Tech-News/")
				.userAgent("Mozilla").get(); // connect to theStar technology
		Document businessDoc = Jsoup
				.connect(
						"http://www.thestar.com.my/RSS/Business/Business-News/")

				.userAgent("Mozilla").get(); // connect to theStar sport
		// clean html String
		log.info("Html contents is being cleaned...");

		String travelDocString = travelDoc.toString().replaceAll("\\<.*?>", "");
		String techDocString = techDoc.toString().replaceAll("\\<.*?>", "");
		String sportDocString = sportDoc.toString().replaceAll("\\<.*?>", "");
		String fitnessDocString = fitnessDoc.toString().replaceAll("\\<.*?>",
				"");
		String businessDocString = businessDoc.toString().replaceAll("\\<.*?>",
				"");

		FileUtils.writeStringToFile(techFile, techDocString);
		FileUtils.writeStringToFile(sportFile, sportDocString);
		FileUtils.writeStringToFile(businessFile, businessDocString);
		FileUtils.writeStringToFile(travelFile, travelDocString);
		FileUtils.writeStringToFile(fitnessFile, fitnessDocString);
		log.info("Done write to file...");

	}
}
