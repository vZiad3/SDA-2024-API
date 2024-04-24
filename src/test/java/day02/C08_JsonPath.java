package day02;

import base_urls.RestFullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C08_JsonPath extends RestFullBaseUrl {
        /*
    Given
        https://restful-booker.herokuapp.com/booking/598
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is "application/json"
    And
        Response body should be like;
        {
            "firstname": "Josh",
            "lastname": "Allen",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "super bowls"
        }
*/

    @Test
    public void jsonPathTest() {

        //Set the Url
        spec.pathParams("first","booking"
                ,"second",162);
        //Set the expected data


        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        //Do assertion
        //1st way: then() method with hamcrest matchers
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Josh"))
                .body("lastname",equalTo("Allen"))
                .body("totalprice",equalTo(111))
                .body("depositpaid",equalTo(true))
                .body("bookingdates.checkin",equalTo("2018-01-01"))     // JSON inside JSON check postman so u cann undrstand more
                .body("bookingdates.checkout",equalTo("2019-01-01"))
                .body("additionalneeds",equalTo("superb owls"));


        //2nd way: By extracting data outside the body with JSONPath
        //Convert Response to JsonPath object

        JsonPath json = response.jsonPath();        // it will convert the api info to json so u can read it

        String firstname = json.getString("firstname");
        String lastName = json.getString("lastname");
        int  totalPrice = json.getInt("totalPrice");
        //boolean depositePaid = json.getString("depositePaid");


        //Retrieve the desired data by using JsonPath object


        Assert.assertEquals("Josh",firstname);//If this assertion fails, the subsequent lines won't execute. Because this is Hard Assertion.
        Assert.assertEquals("Allen",lastName);
        Assert.assertEquals(111,totalPrice);
        //Assert.assertEquals(true,depositePaid);
        //Assert.assertEquals("2018-01-01",);


        //How to use Soft Assertion
        //1st step: Create SoftAssert object

        //2nd step: Do assertion
        //If this assertion fails, the subsequent lines will execute as well. Because this is Soft Assertion.


        //3rd step: Use assertAll() method.

        //Not: Hard assertion is used commonly in market. Because if any failure occurs we must fix it immediately.

    }
}