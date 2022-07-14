package com.polaris.common.dailytestdemo.httpurlconnection;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import javafx.scene.web.WebView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlTest {

    public static void main(String[] args) throws Exception {
/*        Document doc = Jsoup.connect("https://ebooking.ctrip.com/ebkorderv2/domestic/orderlist.html#tab=3").get();
        System.out.println(doc.title());*/
        grabXc();
    }

    public static void testFlie() {
        StringBuffer buffer = new StringBuffer();
        try (FileInputStream fileInputStream = new FileInputStream("/Users/jiangguanfeng/Desktop/未命名.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream("/Users/jiangguanfeng/Desktop/未命名1.txt");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);) {
            byte[] buf = new byte[1024];
            int len = 0;
            while (bufferedInputStream.read(buf) != -1) {
                bufferedOutputStream.write(buf);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("/Users/jiangguanfeng/Desktop/未命名.txt");
             FileWriter fileWriter = new FileWriter("/Users/jiangguanfeng/Desktop/未命名1.txt")) {
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fileReader.read(buf)) != -1) {
                fileWriter.write(new String(buf, 0, len));
                fileWriter.flush();
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void grabXc() throws Exception {
        try (WebClient webClient = new WebClient(BrowserVersion.CHROME)) {

            HtmlPage searchPage = webClient.getPage("https://ebooking.ctrip.com/ebkorderv2/domestic/orderlist.html?micro=true&tab=4");
        }
        URL getUrl = new URL("https://ebooking.ctrip.com/ebkorderv2/domestic/orderlist.html?micro=true&tab=4");
        HttpURLConnection connection = (HttpURLConnection) getUrl
                .openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
        connection.setRequestProperty("Accept-Language", "zh-cn");
        //connection.setRequestProperty("Content-Type","text/html;charset=utf-8");
        connection.setRequestProperty("Cookie","vc=6; _RSG=gDKodQILuz73ABhjLnXxZ9; _RDG=281038e0f3530c294f088767a2744b7ca4; _RGUID=7f785526-a7c9-436a-98fb-87156dacb283; _bfaStatusPVSend=1; OrderCount=0; VoiceType=c_d; logintype=1; userRole_9162133=director; ebk_user_token=5880ca54-c534-4309-9dbe-da9a80ab6ffa; autoLogin=F; GUID=09031162116964013441; CurrentLanguage=SimpChinese; ibulanguage=CN; ibulocale=zh_cn; cookiePricesDisplayed=CNY; _abtest_userid=fd11a70f-3816-4b70-8932-5fb4cd4c4c96; _gcl_au=1.1.1711836473.1656295316; Session=smartlinkcode=U130026&smartlinklanguage=zh&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=; MKT_CKID=1656295317069.3opt7.kx4l; __zpspc=9.1.1656295317.1656295317.1%232%7Cwww.baidu.com%7C%7C%7C%7C%23; appFloatCnt=1; _ga=GA1.2.688993314.1656295317; _jzqco=%7C%7C%7C%7C1656295317277%7C1.175547390.1656295317075.1656295317075.1656295317075.1656295317075.1656295317075.undefined.0.0.1.1; usersign=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpcCI6IjE0MC4yMDUuMTEuNjQiLCJpc3MiOiIxMDAwMDc0MjciLCJodWlkIjo5MTYyMTMzLCJwd2QiOiJERERDODBCRTVFNzZDMDFBQTQ4RTdGNjUwQzYwMEQ1QyIsImV4cCI6MTY1ODk4NjQzN30.DVsCW5qpJLI6qucHPYSIyzSJBS6sygVlUFJ9o82-zXM; randomkey=eb460423-0a20-4276-8151-b83bee2a240d; usertoken=eb460423-0a20-4276-8151-b83bee2a240d; imislogin=9162133^1; imticket=5745EBEAD980A6BB7C256FD0087A1859ED0CC839E26C3CD579796DCB65BF0A53; imuid=_IMEB4952860012; _RF1=140.205.11.67; hotelhst=1164390341; _bfi=p1%3D10650061100%26p2%3D10650009638%26v1%3D108%26v2%3D107; _bfaStatus=success; _bfa=1.1644827284560.2c6lvx.1.1657596819772.1657607870312.24.109.2259; _bfs=1.13; _ubtstatus=%7B%22vid%22%3A%221644827284560.2c6lvx%22%2C%22sid%22%3A24%2C%22pvid%22%3A109%2C%22pid%22%3A0%7D");
        connection.setRequestProperty("sec-ch-ua","\".Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"103\", \"Chromium\";v=\"103\"");
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line;
        StringBuffer result = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        anaXc(result.toString());
    }

    public static void anaXc(String html) {
        Document doc = Jsoup.parse(html);
        System.out.println("抓取内容展示");
/*        Elements Tags = doc.getElementsByTag("img");
        for (Element img : imgs) {
            String imgSrc = img.attr("src");
            if (imgSrc.startsWith("//")) {
                imgSrc = "http:" + imgSrc;
            }
        }*/
    }
}
