package rvl.util;

import java.io.FileReader;
import java.io.IOException;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
// import org.testng.annotations.DataProvider;
// import org.testng.annotations.Test;

public class JsonReader {

   // @DataProvider(name = "Json_parsing")
    public static JSONObject jsonreader(String path) throws IOException, ParseException {

        // parsing the files
        JSONParser jsonparser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonparser.parse(reader);

        JSONObject jsonobject = (JSONObject) obj;

        return jsonobject;
        // JSONArray array = (JSONArray) jsonobject.get("userLogin");

        // String arr[] = new String[array.size()];

        // for (int i = 0; i < array.size(); i++) {
        //     JSONObject users = (JSONObject) array.get(i);
        //     String username = (String) users.get("username");
        //     String password = (String) users.get("password");

        //     arr[i] = username + "," + password;
        // }

        // return arr;
    }

    // @Test(dataProvider = "Json_parsing")
    // public void reader(String data) {
    //     String user[] = data.split(",");
    //     System.out.println("User name from json file is --> : " + user[0]);
    //     System.out.println("User password from json file is --> : " + user[1]);
    // }
}
