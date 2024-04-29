package homeworks.day05;

import base_urls.petStore;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser extends petStore {
    @Test
    public void getUser() throws JsonProcessingException {

        spec.pathParams("first","v2",
                "second","user"
                ,"third","xiad3");

        //"third",getFirstName());

        Response response = given(spec).when().contentType(ContentType.JSON).get("{first}/{second}/{third}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
        String username = json.getString("username");
        System.out.println("message = " + username);

        Assert.assertTrue(username.contains("xiad3"));
}
}
