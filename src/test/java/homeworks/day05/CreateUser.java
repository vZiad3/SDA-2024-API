package homeworks.day05;

import base_urls.petStore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.createUserHwDay05;

import static io.restassured.RestAssured.given;

public class CreateUser extends petStore {
    //Write an automation test that will create a 'user' then read, update and delete the created user using the "https://petstore.swagger.io/" document. (Create a classes for each request.)


    @Test
    public void createUser() throws JsonProcessingException {
        spec.pathParams("first","v2",
                "second","user");

        String expectedStr = """
                {
                  "id": 33,
                  "username": "xiad3",      
                  "firstName": "Ziad",
                  "lastName": "alsh",
                  "email": "z@gotmail.com",
                  "password": "2345",
                  "phone": "12345",
                  "userStatus": 0
                }""";
        ObjectMapper objectMapper = new ObjectMapper();
        createUserHwDay05 payLoad = objectMapper.readValue(expectedStr, createUserHwDay05.class);

        Response response = given(spec).body(payLoad).when().post("{first}/{second}");
        response.prettyPrint();


        JsonPath json = response.jsonPath();
        String message = json.getString("message");
        System.out.println("message = " + message);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(message,"33");

    }
}
