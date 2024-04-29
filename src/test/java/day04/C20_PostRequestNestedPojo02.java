package day04;

import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C20_PostRequestNestedPojo02 extends RestFullBaseUrl {

    /*
       Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
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
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like
       {
            "bookingid": 2243,
            "booking":{
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
                            }
     */
    @Test
    public void test(){

        // Set Url
        spec.pathParams("first","booking");

        // Set Expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo payload = new BookingPojo( "Jane","Doe",111,true,bookingDates,"Extra pillows please");

        // Send request and get respnse
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        // Do Assertions
        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);        // this class will be as pojo
        int bookingId = actualData.getBookingid();
        assertEquals(200,response.statusCode());
        assertEquals(payload.getFirstname(),actualData.getBooking().getFirstname());


        assertEquals(payload.getLastname(),actualData.getBooking().getLastname());
        assertEquals(payload.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(payload.getDepositpaid(),actualData.getBooking().getDepositpaid());
        // since we have another obj of bookingDates we gonna use it so we can access to the info and assert
        assertEquals(bookingDates.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());

        assertEquals(payload.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());

//Ziad
        Assert.assertEquals(payload.getLastname() , actualData.getBooking().getLastname());
Assert.assertEquals(payload.getTotalprice() , actualData.getBooking().getTotalprice());
Assert.assertEquals(payload.getDepositpaid() , actualData.getBooking().getDepositpaid());

Assert.assertEquals(bookingDates.getCheckin() , actualData.getBooking().getBookingdates().getCheckin());
Assert.assertEquals(bookingDates.getCheckout() , actualData.getBooking().getBookingdates().getCheckout());
Assert.assertEquals(payload.getAdditionalneeds() , actualData.getBooking().getAdditionalneeds() );


//delete
        spec.pathParams("first","booking","second", bookingId);
         given(spec).when().delete("{first}/{second}");


    }
//Test(dependsOnMethods = )
//   public void  delete(){

//   spec.pathParam("first","booking");

//


}