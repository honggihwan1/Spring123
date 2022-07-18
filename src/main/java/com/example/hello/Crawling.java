package com.example.hello;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Crawling {

    public static void getStockPriceList() {

        final String stockList = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1";
        Connection conn = Jsoup.connect(stockList);

        try {
            Document document = conn.get();
            String thead = getStockHeader(document); // 칼럼명
            String tbody = getStockList(document);   // 데이터 리스트
            System.out.println(thead);
            System.out.println(tbody);

        } catch (IOException ignored) {
        }
    }

    public static String getStockHeader(Document document) {
        Elements stockTableBody = document.select("table.type_2 thead tr");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
            for (Element td : element.select("th")) {
                sb.append(td.text());
                sb.append("   ");
            }
            break;
        }
        return sb.toString();
    }

    public static String getStockList(Document document) {
        Elements stockTableBody = document.select("table.type_2 tbody tr");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
            if (element.attr("onmouseover").isEmpty()) {
                continue;
            }

            for (Element td : element.select("td")) {
                String text;
                if (td.select(".center a").attr("href").isEmpty()) {
                    text = td.text();
                } else {
                    text = "https://finance.naver.com" + td.select(".center a").attr("href");
                }
                sb.append(text);
                sb.append("   ");
            }
            sb.append(System.getProperty("line.separator")); //줄바꿈
        }
        return sb.toString();
    }

    // 멜론 크롤링
    public static String getMelonMusicList() {

        final String MusicList = "https://www.melon.com/chart/index.htm";
        Connection conn = Jsoup.connect(MusicList);

        try {
            System.out.println("실행");
            Document document = conn.get();
            //String thead = getStockHeader(document); // 칼럼명
            String tbody = getMusicList(document);   // 데이터 리스트
            //System.out.println(thead);
            System.out.println(tbody);

        } catch (IOException ignored) {
            System.out.println("오류");
        }
        return MusicList;
    }

    public static String getMusicList(Document document) {
        Elements stockTableBody = document.select("div.wrap_song_info");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {

            for (Element td : element.select("div.ellipsis")) {
                String text;

                text = td.select(".rank01 a").text(); // 노래 제목
                if (!text.isEmpty())
                    sb.append("제목 " + text);
                sb.append("   ");
                text = td.select("span.checkEllipsis a").text(); // 가수
                if (!text.isEmpty())
                    sb.append("가수 " + text);
            }
            sb.append(System.getProperty("line.separator")); //줄바꿈
        }
        return sb.toString();
    }

    // 네이버 영화 크롤링
    public static void getNaverMovieList() {

        final String MovieList = "https://movie.naver.com/movie/running/current.naver?view=image&tab=normal&order=open";
        Connection conn = Jsoup.connect(MovieList);

        try {
            System.out.println("영화 실행");
            Document document = conn.get();
            //String thead = getStockHeader(document); // 칼럼명
            String tbody = getMovieList(document);   // 데이터 리스트
            //System.out.println(thead);
            System.out.println(tbody);

        } catch (IOException ignored) {
            System.out.println("오류");
        }
    }

    public static String getMovieList(Document document) {
        Elements stockTableBody = document.select("div.lst_wrap");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
            for (Element td : element.select("ul.lst_default_t1 li")) {
                String text;

                stockTableBody = td.select("a > img"); // 노래 제목
                for (int i = 0; i < stockTableBody.size(); i++) {
                    sb.append(stockTableBody.get(i).attr("src"));
                    //if (!text.isEmpty())
                    // sb.append("제목 " + text);
                    text = td.select("strong.tit").text(); // 가수
                    if (!text.isEmpty())
                        sb.append("영화 제목 " + text);
                    sb.append(System.getProperty("line.separator")); //줄바꿈
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // getStockPriceList();
        //getMelonMusicList();
        getNaverMovieList();
    }
}