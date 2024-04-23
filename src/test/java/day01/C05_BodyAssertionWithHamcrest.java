package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class C05_BodyAssertionWithHamcrest {
    /*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
        I send a GET request to the Url
    Then
        HTTP Status Code should be 200
    And
        Response format should be "application/json"
    And
        There should be 200 todos
    And
        "quis eius est sint explicabo" should be one of the todos title
    And
        2, 7, and 9 should be among the userIds
*/

    @Test
    public void assertBodyHamcrestMethod() {

//        1. Set the URL
        String url = "https://jsonplaceholder.typicode.com/todos";

//        2. Set the expected data
        Response response = given().when().get(url);
//        3. Send the request and get the response
        //response.prettyPrint();

//        4. Do Assertion
        // ResrAssured Assertion
        // check if one of the titles contains this title <==
        //check if userId 7 is there or no
        response
                .then()                             // ResrAssured Assertion
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].title",equalTo("delectus aut autem"))
                .body("id",hasSize(200))
                .body("title", hasItem("fugiat veniam minus"))          // check if one of the titles contains this title <==
                .body("userId",hasSize(7))         //check if userId 7 is there or no
                .body("userId",hasItems(2,7,9));

        //hasSize() method checks this list's number of element
        //hasItem() method checks the existence of one single element in a list
        //hasItems() method checks existence of multiple elements in a list

    }
}
