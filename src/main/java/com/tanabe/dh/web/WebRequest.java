package com.tanabe.dh.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Brian on 5/29/2014.
 */
public class WebRequest {

    public static Document getDocumentFromUrl(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
}
