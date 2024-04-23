package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_HeaderAssertions {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Connection should be keep-alive
*/



    @Test
    public void headerTest(){

        // While doing api test you can follow the following 4 steps:

        // Set Url
        String url = ("https://restful-booker.herokuapp.com/booking");

        // Set expected data (if we expect data in certain format) or payload (if we use put or post)

        // Sent request and get response
        given().
                when().
                    get(url).
                        then().                                                 // -- --- -- --- -- - -- - - -
                            statusCode(200).                                    // RestAssured Assertions
                                contentType("application/json").
                                    statusLine("HTTP/1.1 200 OK").
                                        header("Connection","keep-alive");
        // Do assertions



        Response response = given().when().get(url);
        response.prettyPrint();

        //Assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)              // Constant that will never be change   " enum "
                .statusLine("HTTP/1.1 200 OK")
                .header("Connection","keep-alive");


        //2nd way
        int statusCode = response.statusCode();                              // -------------
        Assert.assertEquals(200,statusCode);                            // TestNG Assertions

        String statusLine = response.statusLine();
        Assert.assertEquals("HTTP/1.1 200 OK",statusLine);
    }


}
