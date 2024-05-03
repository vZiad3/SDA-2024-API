package day07;

import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utlilities.ObjectMapperUtilities;

import java.util.Map;

import static day07.C31_CreateBooking.bookingid;
import static io.restassured.RestAssured.given;
import static utlilities.ObjectMapperUtilities.convertJsonToJava;

public class C34_UpdateByPatch extends RestFullBaseUrl {
                /*
    Given
        url: "https://restful-booker.herokuapp.com/booking/:id
    And
        body:     {
                    "firstname" : "Tom",
                    "lastname" : "Hanks",
                }

    When
        user send patch request
    Then
        verify status code is 200
    And
        response is like :
                            {
                        "firstname" : "Tom",
                        "lastname" : "Hanks",
                        "totalprice" : 111,
                        "depositpaid" : true,
                        "bookingdates" : {
                            "checkin" : "2018-01-01",
                            "checkout" : "2019-01-01"
                        },
                        "additionalneeds" : "Lunch"
                    }
     */
     @Test(dependsOnMethods = {"day07.C31_CreateBooking.createBookingTest"})
    public void usingPatch(){
        // Set Url
        spec.pathParams("first","booking"
                ,"second",bookingid );      // class C31 we make static in class level

        String payLoadStr = """

                                    "firstname" : "Tom",
                                    "lastname" : "Hanks"
                                }\
                """;


        Map<String,Object> payload = convertJsonToJava(payLoadStr, Map.class);

        Response response = given(spec).when().patch("{first}/{second}");
        response.prettyPrint();


        Map<String,Object> actualData =convertJsonToJava(response.asString(), Map.class);

         Assert.assertEquals(200,response.statusCode());

    }
}
