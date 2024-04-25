package homeworks.day03.day03Hw;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseUriHw1Day03 {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setUo(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
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

