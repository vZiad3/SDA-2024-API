package day05;


import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class C22_ObjectMaperMap extends JsonPlaceHolderBaseUrl {
    /*
             Given
               1) https://jsonplaceholder.typicode.com/todos
               2) {
                    "userId": 55,
                   "title": "Tidy your room",
                   "completed": false
                   }
            When
                I send POST Request to the Url
            Then
                Status code is 201
            And
                response body is like {
                                        "userId": 55,
                                        "title": "Tidy your room",
                                        "completed": false,
                                        "id": 201
                                        }

    Note: Use map and POJO seperately
    */
    @Test
    public void test() throws JsonProcessingException {
        spec.pathParam("first","todos");
        //{
        //                   55,"Tidy your room",false
        //                   }
        String expectedStr = """
                {
                                                        "userId": 55,
                                                        "title": "Tidy your room",
                                                        "completed": false,
                                                        "id": 201
                                                        }""";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> payLoad = objectMapper.readValue(expectedStr, Map.class);            // it will convert string to map

        //Send reuest and get response
        Response response = given(spec).body(payLoad).when().post("{first}");
            response.prettyPrint();


            //Do assertions
            Map<String,Object>  actualData = objectMapper.readValue(response.asString(), Map.class);     // json file from response i convert it to Map
        assertEquals(201,response.statusCode());
        assertEquals(payLoad.get("userId") , actualData.get("userId"));
        assertEquals(payLoad.get("title") , actualData.get("title"));
        assertEquals(payLoad.get("completed") , actualData.get("completed"));



    }
}