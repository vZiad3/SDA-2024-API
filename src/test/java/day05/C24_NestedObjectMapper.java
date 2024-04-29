package day05;

import base_urls.RestFullBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.BookingPojo;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class C24_NestedObjectMapper extends RestFullBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/466
        When
            I send GET Request to the url
        Then
            Response body should be like that;
            {
                "firstname": "Jane",
                "lastname": "Doe",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Extra pillows please"
            }
*/
    @Test
    public void test() throws JsonProcessingException {
        spec.pathParams("first","booking",
                            "second",466);

        //Set expected data

        String expectedStr = """
                {
                       "firstname": "Jane",
                       "lastname": "Doe",
                       "totalprice": 111,
                       "depositpaid": true,
                       "bookingdates": {
                           "checkin": "2018-01-01",
                           "checkout": "2019-01-01"
                       },
                       "additionalneeds": "Extra pillows please"
                   }""";
        ObjectMapper objectMapper = new ObjectMapper();
        BookingPojo expetedData = objectMapper.readValue(expectedStr, BookingPojo.class);



        Response response = given(spec).when().get("{first}/{second}");
        BookingPojo actualData = objectMapper.readValue(response.asString(), BookingPojo.class);

//Do assertions
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expetedData.getFirstname() , actualData.getFirstname());
        Assert.assertEquals(expetedData.getLastname() , actualData.getLastname());
        Assert.assertEquals(expetedData.getTotalprice() , actualData.getTotalprice());
        Assert.assertEquals(expetedData.getBookingdates() , actualData.getBookingdates());


    }

}
