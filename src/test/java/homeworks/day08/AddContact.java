package homeworks.day08;

import base_urls.hw.HwContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import pojos.hw08.hwContactPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utlilities.ObjectMapperUtilities.convertJsonToJava;

public class Add_Contact extends HwContactBaseUrl {
    /*
    //Write an automation test that will add a 'contact' then read,
     update and delete the created contact
      then negative assert the deleted contact
       using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.
     */

    //Add Contact:
    /*
   Given
       1) https://thinking-tester-contact-list.herokuapp.com/contacts
       2) {
            "firstName": "Ziad",
            "lastName": "alsh",
            "birthdate": "1999-07-11",
            "email": "ziad.alshammary3@gmail.com",
            "phone": "1234567",
            "street1": "3 Main St.",
            "street2": "Apartment B",
            "city": "CA",
            "stateProvince": "H",
            "postalCode": "1234625",
            "country": "KSA"
        }
   When
       I send POST Request to the Url
   Then
       Status code is 201
       And response body should be like
       2) {
            "_id":  708454a2241fcd467c3d2
            "firstName": "Ziad",
            "lastName": "alsh",
            "birthdate": "1999-07-11",
            "email": "ziad.alshammary3@gmail.com",
            "phone": "1234567",
            "street1": "3 Main St.",
            "street2": "Apartment B",
            "city": "CA",
            "stateProvince": "H",
            "postalCode": "1234625",
            "country": "KSA"
             "owner": "6085a21efcfc72405667c3d4",
        "__v": 0
        }
*/

    static hwContactPojo payload;
    public static String contactID;
    public static String contactOwner;

    @Test
    public void AddContactTest() {

        //Set the url
        spec.pathParam("first", "contacts");

        //Set Expected Data
        String payloadStr = """
                {
                            "firstName": "Ziad",
                            "lastName": "alsh",
                            "birthdate": "1999-07-11",
                            "email": "ziad.alshammary3@gmail.com",
                            "phone": "1234567",
                            "street1": "3 Main St.",
                            "street2": "Apartment B",
                            "city": "CA",
                            "stateProvince": "H",
                            "postalCode": "1234625",
                            "country": "KSA"
                        }""";

        payload = convertJsonToJava(payloadStr, hwContactPojo.class);

        //Send the request and get the response
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        //Do assertion
        hwContactPojo actualData = convertJsonToJava(response.asString(), hwContactPojo.class);


        assertEquals(201, response.statusCode());
        assertEquals(payload.getFirstName(), actualData.getFirstName());
        assertEquals(payload.getLastName(), actualData.getLastName());
        assertEquals(payload.getCountry(), actualData.getCountry());
        assertEquals(payload.getBirthdate(), actualData.getBirthdate());
        assertEquals(payload.getPhone(), actualData.getPhone());
        assertEquals(payload.getCity(), actualData.getCity());
        assertEquals(payload.getPostalCode(), actualData.getPostalCode());



        // so we make it dynamic to use it in the Get
        contactID = actualData.get_id();
        contactOwner = actualData.getOwner();

        System.out.println("contactId = " + contactID);

    }
}