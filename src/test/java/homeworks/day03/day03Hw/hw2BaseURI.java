package homeworks.day03.day03Hw;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class hw2BaseURI {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setUo(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static Map<String,Object> jsonPlaceHolderMapperHw(String name, String job){
        Map<String, Object> payLoad = new HashMap<>();
        if (name!=null){
            payLoad.put("name",name);
        }
        if (job!=null){
            payLoad.put("job",job);
        }

        return payLoad;
    }
}

//        "id": 0,
//        "username": "string",
//        "firstName": "string",
//        "lastName": "string",
//        "email": "string",
//        "password": "string",
//        "phone": "string",
//        "userStatus": 0
//        }