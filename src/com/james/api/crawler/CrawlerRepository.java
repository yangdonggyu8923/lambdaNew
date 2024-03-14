package com.james.api.crawler;

import com.james.api.common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerRepository extends AbstractRepository {
    private static CrawlerRepository instance = new CrawlerRepository();

    public CrawlerRepository() {
        map = new HashMap<>();
    }

    public static CrawlerRepository getInstance() {
        return instance;
    }

    private Map<String, ?> map;

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        Document document = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10 * 1000).get();
        Elements elements = document.select("table.byChart");
        Iterator<Element> title = elements.select("p.title").iterator();
        Iterator<Element> artist = elements.select("p.artist").iterator();
        Iterator<Element> rank = elements.select("strong").iterator();
        Map<String, Iterator<Element>> localMap = new HashMap<>();

        localMap.put("title", title);
        localMap.put("artist", artist);
        localMap.put("rank", rank);

        map = localMap;

        return map;
    }
    @Override
    public Map<String, ?> saveMelon(Map<String, ?> paramMap) throws IOException {
        Document document = Jsoup.connect("https://www.melon.com/chart/index.htm").timeout(10*1000).get();
        Elements elements = document.select("tbody");
        Iterator<Element> rank = elements.select("td span.rank").iterator();
        Iterator<Element> artist = elements.select("div.ellipsis.rank02 span").iterator();
        Iterator<Element> title = elements.select("div.ellipsis.rank01 > span").iterator();

        Map<String, Iterator<Element>> localMap = new HashMap<>();

        localMap.put("title", title);
        localMap.put("artist", artist);
        localMap.put("rank", rank);

        map = localMap;
        return map;
    }
}
