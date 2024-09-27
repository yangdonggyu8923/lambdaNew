package com.james.api.crawler;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        CrawlerController crawlerController = new CrawlerController();
        while(true){
            System.out.println("[메뉴]\n" +
                    "0-종료\n" +
                    "1-벅스뮤직\n" +
                    "2-멜론뮤직\n" +
                    "3-ID검색\n" +
                    "4-비번변경\n" +
                    "5-탈퇴\n" +
                    "6-회원목록\n" +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("====벅스뮤직====");
                    Map<String, ?> map = crawlerController.findBugsMusic(sc);

                    System.out.println("벅스뮤직 결과 : ");
                    Iterator<Element> rank = (Iterator<Element>) map.get("rank");
                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");
                    Iterator<Element> title = (Iterator<Element>) map.get("title");

                    while (rank.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("====멜론뮤직====");
                    Map<String, ?> melonMap = crawlerController.findMelonMusic(sc);

                    System.out.println("멜론뮤직 결과 : ");
                    Iterator<Element> melonRank = (Iterator<Element>) melonMap.get("rank");
                    Iterator<Element> melonArtist = (Iterator<Element>) melonMap.get("artist");
                    Iterator<Element> melonTitle = (Iterator<Element>) melonMap.get("title");
                    while (melonRank.hasNext()) {
                        System.out.println(melonRank.next().text() + "위 " + melonArtist.next().text() + " - " + melonTitle.next().text());
                    }
            }
        }

    }
}