package homeworks.day02;

import base_urls.hw.Day02Hw;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class hw extends Day02Hw {

    @Test
    public void hw1(){
//
//      Given
//          https://reqres.in/api/users/2
        spec.pathParams("first","users"
                            ,"second",2);

//
//      When
//          User send GET Request to the URL
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
//      Then
//          HTTP Status Code should be 200
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email", equalTo("janet.weaver@reqres.in")
                        , "data.first_name", equalTo("Janet")
                        , "data.last_name", equalTo("Weaver")
                        , "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


                //THIS IS HARD ASSERT BUT I AM GOING TO USE SOFT
             //  .body("data.email",equalTo("janet.weaver@reqres.in"))
             //  .body("data.first_name",equalTo("Janet"))
             //  .body("data.last_name",equalTo("Weaver"))
             //  .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));










//      And
//          Response format should be "application/json"
//      And
//          "email" is "janet.weaver@reqres.in",
//      And
//          "first_name" is "Janet"
//      And
//          "first_name" is "Weaver"
//      And
//          "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
//

    }
}
