package com.james.api.crawler;

import java.io.IOException;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService {
    private CrawlerRepository crawlerRepository;
    private static CrawlerServiceImpl instance = new CrawlerServiceImpl();

    public CrawlerServiceImpl() {
        this.crawlerRepository = CrawlerRepository.getInstance();
    }

    public static CrawlerServiceImpl getInstance() {
        return instance;
    }

    @Override
    public  Map<String, ?> findNamesFromWeb(Map<String, String> paramMap) throws IOException {
        return crawlerRepository.save(paramMap);

    }

    @Override
    public Map<String, ?> findNamesFromMelonWeb(Map<String, String> paramMap) throws IOException {
        return crawlerRepository.saveMelon(paramMap);
    }

}