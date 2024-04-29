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

public class updateUser extends petStore {
    @Test
    public void updateUser() throws JsonProcessingException {
        spec.pathParams("first","v2",
                "second","user",
                        "third","xiad3");

        String expectedStr = """                
                {
                  "id": 33,
                  "username": "xiad3",      
                  "firstName": "Abdullah",
                  "lastName": "alsh",
                  "email": "z@gotmail.com",
                  "password": "2345",
                  "phone": "12345",
                  "userStatus": 0
                }""";                                       // i will leave the username the same i am going to change the fName
        ObjectMapper objectMapper = new ObjectMapper();
        createUserHwDay05 payload = objectMapper.readValue(expectedStr, createUserHwDay05.class);

        Response response = given(spec).body(payload).put("{first}/{second}/{third}");
        response.prettyPrint();

        Assert.assertEquals(200,response.statusCode());

        JsonPath json = response.jsonPath();
        String message = json.getString("message");
        System.out.println("message = " + message);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(message,"33");



    }
}
