package homeworks.day03;

import base_urls.petStore;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.petStore.petStoreResponse;
import utlilities.ObjectMapperUtilities;

import static io.restassured.RestAssured.given;

public class hw5 extends petStore {

    ////Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
    //(All actions must be done on same pet)
    //(Use Pojo)


    int id = 33;
    petStoreResponse payLoad;
    @Test
    public void createPet(){
        //Set url
        spec.pathParam("first","pet");

        //Set expected Data
        String expectedUrl = """
                {
                  "id": 33,
                  "category": {
                    "id": 3,
                    "name": "Ziad"
                  },
                  "name": "Aldo",
                  "photoUrls": [
                    "string","another"
                  ],
                  "tags": [
                    {
                      "id": 1,
                      "name": "Cute"
                    },
                    {
                      "id": 2,
                      "name": "Cheap"
                    }
                  ],
                  "status": "available"
                }""";

        String payloadStr = "{\n" +
                "  \"id\": 33,\n" +
                "  \"category\": {\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"Ziad\"\n" +
                "  },\n" +
                "  \"name\": \"Aldo\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\",\"another\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Cute\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"Cheap\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

         payLoad = ObjectMapperUtilities.convertJsonToJava(payloadStr, petStoreResponse.class);

        Response response = given(spec).body(payLoad).contentType(ContentType.JSON).when().post("{first}");
        response.prettyPrint();
       // payLoad.getName();
       // payLoad.getTags().get(1).getName();



    }
    @Test(dependsOnMethods = "createPet")
    public void getPet() {
        spec.pathParams("first", "pet",
                "second", id);

        //Send request
        Response response = given().when().get("{first}/{second}");
        response.prettyPrint();

    }
        @Test
        public void updatePet(){
        payLoad.setName("Aslan");
            payLoad.getTags().get(0).setName("Sick");
            payLoad.setStatus("Pending");
        }

    }


