
package homeworks.day03;

import homeworks.day03.day03Hw.BaseUriHw4;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class hw4 extends BaseUriHw4 {
    @Test
    public void hw4() {
            /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12
    Note: Print using JsonPath: response.jsonPath().prettyPrint();
*/
        spec.pathParams("first", "api",
                "second", "productsList");

        Response response = given(spec).when().contentType(ContentType.JSON).get("{first}/{second}");
        //   response.prettyPrint();
        response.jsonPath().prettyPrint();

        JsonPath json = response.jsonPath();

        List<Object> women = json.getList("products.category.usertype.findAll{it.usertype=='Women'}");
        System.out.println("women = " + women);
        int womenCount = women.size();
        System.out.println("w = " + womenCount);
        Assert.assertEquals(12,womenCount);
    }
}
