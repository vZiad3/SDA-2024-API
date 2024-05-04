package homeworks.day04;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class hw4FromThePreviousDay extends AutomationExercies {
        /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12
    Note: Print using JsonPath: response.jsonPath().prettyPrint();
    */

    @Test
    public void task04() {

        //Set the Url
        spec.pathParams("first", "api", "second", "productsList");

        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        //response.prettyPrint();

        //Assertions
        response.then().statusCode(200);

        //Assert that the number of "Women" user type is 12
        JsonPath json = response.jsonPath();
        int numOfWomen = json.getList("products.findAll { it.category.usertype.usertype == 'Women' }").size();
        System.out.println(numOfWomen);
        Assert.assertEquals(12, numOfWomen);
        json.prettyPrint();

    }
}
