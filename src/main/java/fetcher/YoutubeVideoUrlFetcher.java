package fetcher;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YoutubeVideoUrlFetcher {


  public String imFeelingLuckySearch(String search) {
    try {
      return fetchUrlFromHtml(fetchYoutubeSearchHtml(search));
    } catch (Exception e) {
      e.printStackTrace();
      return e.getClass().getCanonicalName();
    }
  }

  public ArrayList<String> imFeelingLuckySearch(ArrayList<String> searchList) {
    ArrayList<String> urls = new ArrayList<>();
    for (String search : searchList)
      urls.add(imFeelingLuckySearch(search));
    return urls;
  }

  String fetchYoutubeSearchHtml(String lookup) throws UnsupportedEncodingException {
    URLEncoder.encode(lookup, "UTF-8");
    lookup = lookup.replaceAll("\\s", "+").replaceAll("[-_]", "");
    String content = null;
    URLConnection connection;
    Scanner scanner = null;
    try {
      System.out.println("https://www.youtube.com/results?search_query=" + lookup);
      connection = new URL("https://www.youtube.com/results?search_query=" + lookup).openConnection();
      scanner = new Scanner(connection.getInputStream());
      scanner.useDelimiter("\\Z");
      content = scanner.next();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      scanner.close();
    }
    return content;
  }

  public String fetchUrlFromHtml(String html) {
    Pattern pattern = Pattern.compile("(?:item-section\\\")(?is).+?(href=\"/watch[^\\\"]+)");
    Matcher matcher = pattern.matcher(html);

    if (matcher.find()) {
      return "youtube.com" + matcher.group(1).substring(6, matcher.group(1).length());
    } else {
      return "NOT FOUND";
    }
  }
}
