package day01;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C03_HeaderAndBodyAssertions {

/*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User sends a GET Request to the URL
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "Clarusway"
   And
       Server is "Cowboy"
*/

    @Test
    void bodyTest() {
       String url = "https://restful-booker.herokuapp.com/booking/0";
//        User sends a GET Request to the URL
        Response response = given().get(url);

        response.prettyPrint();

//        HTTP Status code should bex 404
//        Status Line should be HTTP/1.1 404 Not Found
//        Server is "Cowboy"

        //1st way: We can assert headers with method chain.
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server","Cowboy");

        //2nd way:
        int statusCode = response.statusCode();
        Assert.assertEquals(404,statusCode);
        
        String statusLine = response.statusLine();
        Assert.assertEquals("HTTP/1.1 404 Not Found",statusLine);

        Assert.assertEquals("Cowboy" ,response.header("Server"));
        ;


//        Response body contains "Not Found"
        String responseString = response.asString();
        System.out.println("responseString = " + responseString);

        //If the boolean value between parenthesis is TRUE test will pass
            boolean isContains = responseString.contains("Not Found");
            boolean isEqual = responseString.equals("Not Found");
        System.out.println("isCOntains = " + isContains);
        System.out.println("isEqual = " + isEqual);

        Assert.assertTrue(isContains);
//        Response body does not contain "Clarusway"
        boolean isContainsClarusway = responseString.contains("Clarusway");             // There's no Clarusway in the body
        Assert.assertFalse(isContainsClarusway);                                        // it should pass
        //If the boolean value between parenthesis is FALSE test will pass


    }

}
