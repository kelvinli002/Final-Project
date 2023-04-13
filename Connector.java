import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// methods to get data from API
class Connector {
  String urlString;

  Connector(String urlString) {
    this.urlString = urlString;
  }

  StringBuilder getDataFromAPI(String path) {
    String fullURL = urlString + path;
    System.out.println("Trying URL: " + fullURL);
    URL url = null;
    try {
      url = new URL(fullURL);
      System.out.println("Successful");
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Trying Http: " + url);
    HttpURLConnection conn = null;
    try {
      conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();
      System.out.println("Successful");
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Getting response code: " + conn);
    Integer responseCode = null;
    try {
      responseCode = conn.getResponseCode();
      System.out.println("Response code: " + responseCode);
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (responseCode == 200) {
      System.out.println("Trying openStream: " + url);
      Scanner streamScanner = null;
      try {
        streamScanner = new Scanner(url.openStream());
        System.out.println("Successful");
      } catch (Exception e) {
        e.printStackTrace();
      }

      System.out.println("Saving data to StringBuilder from scanner: " + streamScanner);
      StringBuilder infoString = new StringBuilder();
      while (streamScanner.hasNext()) {
        infoString.append(streamScanner.nextLine());
      }
      System.out.println("Done");
      return infoString;
    } else
      throw new RuntimeException("HttpResponseCode: " + responseCode);
  }

  JSONArray getJSONArray(StringBuilder infoString) {
    System.out.println("Trying parser on StringBuilder and saving to JSONArray...");
    JSONParser parser = new JSONParser();
    JSONArray jsonArray = null;
    try {
      jsonArray = (JSONArray) parser.parse(String.valueOf(infoString));
      System.out.println("Successful");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonArray;
  }
/*
  JSONObject getJSONObject(StringBuilder infoString) {
    System.out.println("Trying parser on StringBuilder and saving to JSONObject...");
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = null;
    try {
      jsonObject = (JSONObject) parser.parse(String.valueOf(infoString));
      System.out.println("Successful");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonObject;
  }
*/
}
