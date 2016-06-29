package com.psl.sc.launcher;

import com.psl.sc.crawler.TestCrawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class ApplicationLauncher {
	public static void main(String[] args) throws Exception {
		String crawlStorageFolder = "D:/crawlStorage";
		int numberOfCrawlers = 7;

		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorageFolder);
		config.setProxyHost("ptproxy.persistent.co.in");
		config.setProxyPort(8080);
		config.setProxyUsername("shrinivas_shukla");
		config.setProxyPassword("CooperSheldon!96");
		config.setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
		config.setResumableCrawling(true);
		config.setPolitenessDelay(200);
		config.setFollowRedirects(true);
		config.setIncludeHttpsPages(true);
		config.setMaxDepthOfCrawling(0);

		/*
		 * Instantiate the controller for this crawl.
		 */
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig,
				pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher,
				robotstxtServer);

		/*
		 * For each crawl, you need to add some seed urls. These are the first
		 * URLs that are fetched and then the crawler starts following links
		 * which are found in these pages
		 */
//		controller.addSeed("http://www.ics.uci.edu/~lopes/");
//		controller.addSeed("http://www.ics.uci.edu/~welling/");
		controller.addSeed("http://www.ics.uci.edu/");

		/*
		 * Start the crawl. This is a blocking operation, meaning that your code
		 * will reach the line after this only when crawling is finished.
		 */
		controller.start(TestCrawler.class, numberOfCrawlers);

	}
}
