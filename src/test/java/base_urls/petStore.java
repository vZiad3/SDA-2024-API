package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class petStore {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setUo(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io")
                .setContentType(ContentType.JSON)
                .build();
    }
}

 // {
 //     "id": 35,
 //     "username": "string",
 //     "firstName": "string",
 //     "lastName": "string",
 //     "email": "string",
 //     "password": "string",
 //     "phone": "string",
 //     "userStatus": 0
 //     }