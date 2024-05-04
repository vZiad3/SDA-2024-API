package homeworks.day08;

import base_urls.hw.HwContactBaseUrl;

import base_urls.hw.HwContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import pojos.hw08.hwContactPojo;

import static homeworks.day08.Add_Contact.contactID;
import static homeworks.day08.Add_Contact.contactOwner;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utlilities.ObjectMapperUtilities.convertJsonToJava;

public class GetContact extends HwContactBaseUrl {
    /*
    Given
        url: https://thinking-tester-contact-list.herokuapp.com/contacts/

    When
        user send GET request
    Then
        verify status code is 200
    And
        response is like :
       {
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
    @Test(dependsOnMethods = {"Homeworks.day8.Add_Contact.AddContactTest"})
    public void GetContactTest() {

        //Set the url
        spec.pathParam("first", "contacts");

        //Set Expected Data
        String expectedStr = "{\n" +
                "    \"_id\": \"" + contactID + "\",\n" +
                "    \"firstName\": \"Ziad\",\n" +
                "    \"lastName\": \"Alsh\",\n" +
                "    \"country\": \"KSA\",\n" +
                "    \"birthdate\": \"1999-07-11\",\n" +
                "    \"phone\": \"1234567\",\n" +
                "    \"city\": \"CA\",\n" +
                "    \"postalCode\": \"12345\",\n" +
                "    \"stateProvince\": \"KS\",\n" +
                "    \"street1\": \"3 Main St.\",\n" +
                "    \"street2\": \"Apartment A\",\n" +
                "    \"email\": \"ziad.alshammary3@gmail.com\",\n" +
                "    \"owner\": \"" + contactOwner + "\",\n" +
                "    \"__v\": 0\n" +
                "}";

        hwContactPojo expectedData = convertJsonToJava(expectedStr, hwContactPojo.class);

        //Send the request and get the response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();


        //Do assertion
        assertEquals(200, response.statusCode());
    }
}