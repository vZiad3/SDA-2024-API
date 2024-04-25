package homeworks.day03;

import homeworks.day03.day03Hw.BaseUriHw1Day03;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class hw1 extends BaseUriHw1Day03 {
      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
    @Test
    public void hw1(){
        spec.pathParams("first","api",
                            "second","users");
        Map<String,Object> payload = BaseUriHw1Day03.jsonPlaceHolderMapperHw("morpheus","leader");
        Response response = given(spec).body(payload).when().post("{first}/{second}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
        Assert.assertEquals(201,response.statusCode());

        Map<String,Object> actualData = response.as(Map.class);
        Assert.assertEquals(payload.get("name"),actualData.get("name"));
        Assert.assertEquals(payload.get("job"),actualData.get("job"));



        // those i cant assert it because it's showing after i use post ******* ^$&*

        //Assert.assertEquals(payload.get("id"),actualData.get("id"));
        //Assert.assertEquals(payload.get("createdAt"),actualData.get("createdAt"));


    }


}
