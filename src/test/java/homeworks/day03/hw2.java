package homeworks.day03;

import homeworks.day03.day03Hw.hw2BaseURI;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class hw2 extends hw2BaseURI {
    /*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/
    //https://petstore.swagger.io/v2/user

    //https://petstore.swagger.io/v2/user/

    @Test
    public void hw2(){
        spec.pathParams("first","v2",
                "second","user");

        // for test
        //String url ="https://petstore.swagger.io/v2/user/zzz";
   Map<String,Object> payLoad = new HashMap<>();
        payLoad.put("id", 33);
        payLoad.put("username", "ZiadTheThird");
        payLoad.put("firstName", "X");
        payLoad.put("lastName", "Alsh");
        payLoad.put("email", "XTheThird@gmail.com");



        Response response = given(spec).body(payLoad).contentType(ContentType.JSON).when().post("{first}/{second}");
        response.prettyPrint();



     JsonPath jsonPath = response.jsonPath();

     response
             .then()
             .statusCode(200);                      // 201 for sucess message of creating user and i am getting 200 so it's the same since we can check about the id and the info of it



}}
