package com.juja.roy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dmitriyroy on 27.03.17.
 */
public class Main {
    public static BufferedWriter logFileWriter;
    public static void main(String[] args) throws IOException {
//        String url = "http://ita.biz.ua";
        String url = "http://konditer.dp.ua";
        String siteCode = "cp1251";
//        String outFilePath = "/home/dmitriyroy/Data/HtmlFile.txt";
        String outFilePath = "d:/!!!_0/HtmlFile_" + url.replace(":","").replace("/","").replace("https","").replace("http","") + ".txt";
        
        File outFile = new File(outFilePath);
        // открываем лог-файл. дописываем в конец - параметр true
//        try {
//            logFileWriter = new BufferedWriter(new FileWriter(outFilePath, true));
//            logFileWriter.write("===========-======== start "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date(System.currentTimeMillis()))+ "\n");
//            logFileWriter.write("=================== end   "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date(System.currentTimeMillis()))+ "\n");
//            logFileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        HtmlGrabber htmlGrabber = new HtmlGrabber(outFile);
        htmlGrabber.grabSite(url, siteCode);

    }
}
