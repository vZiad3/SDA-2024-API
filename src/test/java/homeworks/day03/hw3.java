package homeworks.day03;

import homeworks.day03.day03Hw.hw2BaseURI;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class hw3 extends hw2BaseURI {

  //  Using the https://petstore.swagger.io/ document, write an automation test that finds the number of "pets" with the status "available" and asserts that there are more than 100.

  //  https://petstore.swagger.io         /v2/pet/1
//    https://petstore.swagger.io/v2/pet/findByStatus?status=available      // for the condition with available

    @Test
    public void hw3() {


//        spec.pathParams("first", "v2",
//                "second", "pet");
        String url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";

        Response response = given().contentType(ContentType.JSON).when().get(url);
      //  response.prettyPrint();
        response.
                then()
                .statusCode(200);

        JsonPath jsonPath = response.jsonPath();

        List<Object> statusAva = jsonPath.getList("tags.status");
        int totalAva = statusAva.size();
        System.out.println("aa = " + totalAva);

        Assert.assertTrue(totalAva > 100);   // total available is 506


    }
}
