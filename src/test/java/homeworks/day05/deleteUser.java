package homeworks.day05;

import base_urls.petStore;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteUser extends petStore {
    @Test
    public void delete() throws JsonProcessingException {

        spec.pathParams("first","v2",
                "second","user"
                ,"third","xiad3");

        //"third",getFirstName());

        Response response = given(spec).when().contentType(ContentType.JSON).delete("{first}/{second}/{third}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
        String message = json.getString("message");
        System.out.println("message = " + message);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(message,"xiad3");

}//
}
