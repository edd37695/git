package com.example.demo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class WebCrawlerService {

	public void crawlWebsite(String stockCode) throws InterruptedException {
		String baseUrl = "https://mops.twse.com.tw/mops/web/ezsearch";
		String url = baseUrl + "?co_id=" + stockCode;
//    	String url = "https://mops.twse.com.tw/mops/web/ezsearch?co_id=6669";
		try {
			// 设置请求头ajfdkjdjfs
			Map<String, String> headers = new HashMap<>();
			headers.put("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
			headers.put("Accept-Encoding", "gzip, deflate, br");
			// 更多请求头...

			// 设置 Cookies
			Map<String, String> cookies = new HashMap<>();
			cookies.put("jcsession", "jHttpSession@5b1ac9b0");
			cookies.put("_ga_J2HVMN6FVP", "GS1.1.1689351519.1.1.1689351534.0.0.0");
			cookies.put("_gid", "GA1.3.1149102023.1692019456");
			// 更多 Cookies...

			// 发起请求
			Connection.Response response = Jsoup.connect(url).headers(headers).cookies(cookies)
					.method(Connection.Method.GET).execute();

			Document document = response.parse();
			System.out.println("页面的 HTML 源代码：\n" + document.html());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
