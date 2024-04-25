package homeworks.day1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class hw1 {
    String url;

    Response response;
    @Test
    public void towHundered(){

    //    Given
    //        https://reqres.in/api/users/3
        url = "https://reqres.in/api/users/3";

    //    When
    //        User sends a GET Request to the url
        Response response = given().get(url);
        response.prettyPrint();
        //    Then
    //        HTTP Status Code should be 200

        //int statusCode = response.statusCode();


    //    And
    //        Content Type should be JSON
    //    And
    //        Status Line should be HTTP/1.1 200 OK
        String statusLine = response.statusLine();
    //
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");


    }
    @Test
    public void fourHundered(){

    //   Given
    //       https://reqres.in/api/users/23
        url = "https://reqres.in/api/users/23";
    //   When
    //       User send a GET Request to the url
    //   Then
        Response response = given().get(url);
        response.prettyPrint();
    //       HTTP Status code should be 404
    //   And
    //       Status Line should be HTTP/1.1 404 Not Found
    //   And
    //       Server is "cloudflare"
    //   And
    //       Response body should be empty
        //boolean isEmpty = response.body(Empt)
        response.
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found").
                header("Server","cloudflare").
                contentType(ContentType.JSON).
                body("isEmpty()", Matchers.is(true));       // i used isempty method to check if the body is empty or no
    //

    }
}
