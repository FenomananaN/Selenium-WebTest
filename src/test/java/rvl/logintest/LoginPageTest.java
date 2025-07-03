package rvl.logintest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rvl.logintest.pages.LoginPage;
import rvl.util.ConfigReader;
import rvl.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest  {

    @DataProvider
    public Iterator<User> getLoginData() {

        //"src/test/resources/data.json"
        JSONObject $jsonUser = new JSONObject();
        try {
            $jsonUser = JsonReader.jsonreader("src/test/resources/data.json");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        JSONArray userArrays = (JSONArray) $jsonUser.get("userLogin");
        
        List<User> loginData = new ArrayList<>();
        
        for (Object item : userArrays) {
            JSONObject userArray = (JSONObject) item;
        
            loginData.add(new User(
                (String) userArray.get("email"),
                (String) userArray.get("password"),
                (Boolean) userArray.get("isValid")
            ));
        }
      
        return loginData.iterator();
    }

    @Test(dataProvider = "getLoginData")
    public void testLoginFeature(User user) {

        String email = user.getEmail();
        String password = user.getPassword();
        boolean isValidUser = user.isValidUser();

        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        String baseUrl = ConfigReader.get("baseUrl");

        driver.get(baseUrl+"login");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(email, password);
        
        if (!isValidUser) {
            System.out.println("Login failed as expected for invalid user");
            assertEquals(loginPage.getErrorMessageText(), "Identifiants invalides.");
        } else {
            System.out.println("Login successful");
        }
        
        System.out.println("");
    }
}