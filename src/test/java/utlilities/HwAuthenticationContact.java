package utlilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HwAuthenticationContact {


    public static String generateToken() {//Contact List

        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("email", "ziad.alshammary3@gmail.com");
        mapBody.put("password", "135789");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        return response.jsonPath().getString("token");
    }

}