package day01;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class C01_RequestAndResponse {

    public static void main(String[] args) {
            /*
    Given
        https://restful-booker.herokuapp.com/booking
        
    When
        User sends a GET Request to the url
    Then
        Print Status Code (should be 200)
    And
        Print Content Type (should be JSON)
    And
        Print Status Line (should be HTTP/1.1 200 OK)
    And
        Print Connection and Date headers on console
    And
        Print all headers on console

*/
        String url = "https://restful-booker.herokuapp.com/booking";
        Response response = given().get(url);

        System.out.println(response);       // it will show the reference of the response
        
        //response.prettyPrint(); // now it will print the request


        int statuseCode = response.statusCode();
      //
       System.out.println("statuseCode = " + statuseCode);

      // // How to print status line
       String statusLine = response.statusLine();
       System.out.println("statusLine = " + statusLine);

      // // How to print content type
      String contentType = response.contentType();
      System.out.println("contentType = " + contentType);

      // // Connection

      // // How can i get value from headers  ==> header only one value because it's String
      String conn = response.header("Connection");
       System.out.println("conn = " + conn);

      // String date = response.header("Date");
      // System.out.println("date = " + date);

      // //How to get all Headers
      Headers headers = response.headers();
      System.out.println("headers = " + headers);

       // Check the response time
       System.out.println("response.time = " + response.time());

    }
}
