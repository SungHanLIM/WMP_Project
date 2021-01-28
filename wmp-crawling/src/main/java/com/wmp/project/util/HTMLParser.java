package com.wmp.project.util;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLParser {
	private String url;
	private String html;
	private boolean removeTag;

	public HTMLParser(String url, boolean removeTag) throws IOException {
		this.url = url;
		this.removeTag = removeTag;
		init();
	}

	private void init() throws IOException {
		Connection conn = Jsoup.connect(url);
		Document doc = conn.get();
		setHtml(removeTag == true ? doc.text() : doc.toString());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
}
