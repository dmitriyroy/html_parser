package com.juja.roy.grabber;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by dmitriyroy on 27.03.17.
 */
public class HtmlGrabber {
    File htmlFile;
    String outFilePath;
    public HtmlGrabber() {
    }

    public HtmlGrabber(File htmlFile) {
        this.htmlFile = htmlFile;
    }

    public HtmlGrabber(String outFilePath) {
        this.outFilePath = outFilePath;
        this.htmlFile = new File(outFilePath);
    }

    public File getHtmlFile() {
        return htmlFile;
    }

    public void setHtmlFile(File htmlFile) {
        this.htmlFile = htmlFile;
    }

    public String getOutFilePath() {
        return outFilePath;
    }

    public void setOutFilePath(String outFilePath) {
        this.outFilePath = outFilePath;
    }

    public File grabSite(String url, String codepage) throws IOException {

        BufferedWriter outFileWriter;
        StringBuilder sb = new StringBuilder();
        URL pageURL = new URL(url);
        URLConnection uc = pageURL.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        uc.getInputStream(), codepage));
        try {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
                sb.append("\n");
            }
        } finally {
            br.close();
        }

        outFileWriter = new BufferedWriter(new FileWriter(this.htmlFile.getCanonicalPath(), false));
        outFileWriter.write(sb.toString());
        outFileWriter.close();

        return this.htmlFile;
    }
}
