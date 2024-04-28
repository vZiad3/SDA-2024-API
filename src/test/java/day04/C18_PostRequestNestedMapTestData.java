package day04;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.RestulTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class C18_PostRequestNestedMapTestData extends RestulTestData {




    /*
    Given
        https://restful-booker.herokuapp.com/booking/827
    When
        I send GET Request to the url
    Then
        Status code should be 200
        Response body should be like that;
            {
                 "John","Smith",111,true,bookingdates,"Breakfast"
            }
 */
    @Test
    public void test(){
        spec.pathParams("first","booking"
                        ,"second",243);

        //Set expected data
        Map<String,Object> bookingDates = C18_PostRequestNestedMapTestData.bookingDatesMapper("2018-01-01","2019-01-01");
        Map<String,Object> expectedData = C18_PostRequestNestedMapTestData.bookingMapper("John","Smith",111,true,bookingDates,"Breakfast");

        //expectedData.get( (Map) bookingDates.get("checkin") );

        //send req
        spec.pathParams("first","booking","second",451);
        Response response = given(spec).when().get("{first}/{second} ");
        response.prettyPrint();

        Map<String,Object> actualData = response.as(Map.class);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("depositepaid"), actualData.get("depositepaid"));
        Assert.assertEquals(expectedData.get(bookingDates.get("checkin")) ,   ((Map) actualData.get("bookingDates")).get("checkin")  );
        Assert.assertEquals(expectedData.get(bookingDates.get("checkout")) ,   ((Map) actualData.get("bookingDates")).get("checkout")  );

        Assert.assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

    }
}