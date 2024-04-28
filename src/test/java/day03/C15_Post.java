package day03;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;
import testdata.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class C15_Post extends JsonPlaceHolderTestData {
    /*
     Given
        https://jsonplaceholder.typicode.com/todos
        {
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
        }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/
    @Test
    public void PostRequestPojoTest() {
        // Set Url
        spec.pathParam("first", "todos");

        // Set Expected Data

        JsonPlaceHolderPojo payLoad = new JsonPlaceHolderPojo(55, "Tidy your room", false);
        System.out.println(payLoad);

        // Sent request and get response
        Response response = given().body(payLoad).when().post("{first}");
        response.prettyPrint();

        // Do assert
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);

        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(payLoad.getUserId(),actualData.getUserId());
        Assert.assertEquals(payLoad.getTitle(),actualData.getTitle());
        Assert.assertEquals(payLoad.getCompleted(),actualData.getCompleted());
    }
}
