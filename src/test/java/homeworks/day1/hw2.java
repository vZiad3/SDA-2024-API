package homeworks.day1;

import base_urls.hw.Day02Hw;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class hw2 extends Day02Hw {
    @Test
    public void hw2() {

//      Given
//        https://reqres.in/api/unknown/3
        spec.pathParams("first", "unknown",
                "second", 3);
//      When
//          User send a GET request to the URL
        Response response = given(spec).get("{first}/{second}");
//      Then
//          HTTP Status Code should be 200
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)                      // ---- already declared in the BaseUrl but i wrote for the task
                .body("data.id", equalTo(3)
                        , "data.name", equalTo("true red")
                        , "data.year", equalTo(2002)
                        , "data.color", equalTo("#BF1932")
                        , "data.pantone_value", equalTo("19-1664")
                        , "support.url", equalTo("https://reqres.in/#support-heading")
                        , "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")
                );
//      And
//          Response content type is "application/json; charset=utf-8"
//      And
//          Response body should be like;(Soft Assertion)
//      {
//      "data": {
//          "id": 3,
//          "name": "true red",
//          "year": 2002,
//          "color": "#BF1932",
//          "pantone_value": "19-1664"
//      },
//      "support": {
//          "url": "https://reqres.in/#support-heading",
//          "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
//      }
//      }

//

//  }

    }
}
