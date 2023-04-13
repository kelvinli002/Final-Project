import org.json.simple.JSONObject;

class Formatter {
  static StringBuilder tryFormatting(JSONObject jsonObject) {
    System.out.println("Formatting data...");
    StringBuilder formattedData = null;
    System.out.println("Trying for each API");
    try {
      System.out.println("Trying posts...");
      formattedData = Formatter.formatPosts(jsonObject);
      System.out.println("Successful");
      return formattedData;
    } catch (Exception e) {
      System.out.println("Unsuccessful, trying next...");
    }
    try {
      System.out.println("Trying comments...");
      formattedData = Formatter.formatComments(jsonObject);
      System.out.println("Successful");
      return formattedData;
    } catch (Exception e) {
      System.out.println("Unsuccessful, trying next...");
    }
    try {
      System.out.println("Trying todos..."); //has to come before albums because of matching keys
      formattedData = Formatter.formatTodos(jsonObject);
      System.out.println("Successful");
      return formattedData;
    } catch (Exception e) {
      System.out.println("Unsuccessful, trying next...");
    }
    try {
      System.out.println("Trying albums...");
      formattedData = Formatter.formatAlbums(jsonObject);
      System.out.println("Successful");
      return formattedData;
    } catch (Exception e) {
      System.out.println("Unsuccessful, trying next...");
    }
    try {
      System.out.println("Trying photos...");
      formattedData = Formatter.formatPhotos(jsonObject);
      System.out.println("Successful");
      return formattedData;
    } catch (Exception e) {
      System.out.println("Unsuccessful, trying next...");
    }
    try {
      System.out.println("Trying users...");
      formattedData = Formatter.formatUsers(jsonObject);
      System.out.println("Successful");
      return formattedData;
    } catch (Exception e) {
      System.out.println("Unsuccessful, returning StringBuilder");
      return formattedData;
    }
  }
  
  static StringBuilder formatPosts(JSONObject jsonObject) {
    StringBuilder formattedData = new StringBuilder();
    formattedData
        .append("User ID: " + jsonObject.get("userId").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("ID: " + jsonObject.get("id").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Title: " + jsonObject.get("title").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Body: " + jsonObject.get("body").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator());

    return formattedData;
  }

  static StringBuilder formatComments(JSONObject jsonObject) {
    StringBuilder formattedData = new StringBuilder();
    formattedData
        .append("Post ID: " + jsonObject.get("postId").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("ID: " + jsonObject.get("id").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Name: " + jsonObject.get("name").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Email: " + jsonObject.get("email").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Body: " + jsonObject.get("body").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator());

    return formattedData;
  }

  static StringBuilder formatAlbums(JSONObject jsonObject) {
    StringBuilder formattedData = new StringBuilder();
    formattedData
        .append("User ID: " + jsonObject.get("userId").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("ID: " + jsonObject.get("id").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Title: " + jsonObject.get("title").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator());

    return formattedData;
  }

  static StringBuilder formatPhotos(JSONObject jsonObject) {
    StringBuilder formattedData = new StringBuilder();
    formattedData
        .append("Album ID: " + jsonObject.get("albumId").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("ID: " + jsonObject.get("id").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Title: " + jsonObject.get("title").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("URL: " + jsonObject.get("url").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Thumbnail URL: " + jsonObject.get("thumbnailUrl").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator());

    return formattedData;
  }

  static StringBuilder formatTodos(JSONObject jsonObject) {
    StringBuilder formattedData = new StringBuilder();
    formattedData
        .append("User ID: " + jsonObject.get("userId").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("ID: " + jsonObject.get("id").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Title: " + jsonObject.get("title").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("Completed: " + jsonObject.get("completed").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator());

    return formattedData;
  }

  static StringBuilder formatUsers(JSONObject jsonObject) {
    StringBuilder formattedData = new StringBuilder();
    formattedData    
      .append("ID: " + jsonObject.get("id").toString())
      .append(System.lineSeparator())
      .append(System.lineSeparator())

      .append("Name: " + jsonObject.get("name").toString())
      .append(System.lineSeparator())
      .append(System.lineSeparator())

      .append("Username: " + jsonObject.get("username").toString())
      .append(System.lineSeparator())
      .append(System.lineSeparator())

      .append("Email: " + jsonObject.get("email").toString())
      .append(System.lineSeparator())
      .append(System.lineSeparator());

    JSONObject usersAddress = (JSONObject) jsonObject.get("address");

    formattedData
      .append("Address: ")
      .append(System.lineSeparator())
      .append(System.lineSeparator())

        .append("  Street: " + usersAddress.get("street").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("  Suite: " + usersAddress.get("suite").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("  City: " + usersAddress.get("city").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())

        .append("  Zipcode: " + usersAddress.get("zipcode").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator());

    JSONObject addressGeo = (JSONObject) usersAddress.get("geo");

      formattedData
        .append("  Geo: ")
        .append(System.lineSeparator())
        .append(System.lineSeparator())
  
          .append("    Lat: " + addressGeo.get("lat").toString())
          .append(System.lineSeparator())
          .append(System.lineSeparator())
    
          .append("    Long: " + addressGeo.get("lng").toString())
          .append(System.lineSeparator())
          .append(System.lineSeparator());  

    formattedData
      .append("Phone: " + jsonObject.get("phone").toString())
      .append(System.lineSeparator())
      .append(System.lineSeparator())
    
      .append("Website: " + jsonObject.get("website").toString())
      .append(System.lineSeparator())
      .append(System.lineSeparator());

    JSONObject usersCompany = (JSONObject) jsonObject.get("company");

    formattedData
      .append("Company: ")
      .append(System.lineSeparator())
      .append(System.lineSeparator())

        .append("  Name: " + usersCompany.get("name").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())
  
        .append("  Catchphrase: " + usersCompany.get("catchPhrase").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator())
  
        .append("  BS: " + usersCompany.get("bs").toString())
        .append(System.lineSeparator())
        .append(System.lineSeparator());

    return formattedData;
  }
}