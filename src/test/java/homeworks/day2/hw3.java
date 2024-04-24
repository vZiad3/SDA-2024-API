package homeworks.day2;

import base_urls.hw.Day03Hw;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class hw3 extends Day03Hw {
    @Test
    public void hw3(){
 //
 //      Given
 //             https://reqres.in/api/unknown/
        spec.pathParam("first", "unknown");
 //      When
 //           I send GET Request to the URL
        Response response = given(spec).get("{first}");
        response.prettyPrint();
 //      Then
 //           1)Status code is 200
        response.then().statusCode(200);

        //           2)Print all pantone_values
        JsonPath jsonPath = response.jsonPath();
        //List<String> pantoneValues = jsonPath.getList("findAll{it.data.pantone_value}.pantone_value");
        List<Object> pantoneValues = jsonPath.getList("data.pantone_value");
        System.out.println("pantoneValues = " + pantoneValues);

 //           3)Print all ids greater than 3 on the console
        List<Integer> allIds = jsonPath.getList("data.findAll{it.id>3}.id");    // find all inside Data
       int totalNumberOfIds = allIds.size();
        System.out.println("allIds = " + totalNumberOfIds);
 //             Assert that there are 3 ids greater than 3
        Assert.assertEquals(3,totalNumberOfIds);

 //           4)Print all names whose ids are less than 3 on the console
        List<Object> allNames = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("allNames = " + allNames);
 //             Assert that the number of names whose ids are less than 3 is 2
        int assertNames = allNames.size();
        System.out.println(assertNames);
        Assert.assertEquals(2,assertNames);
 //

    }
}
