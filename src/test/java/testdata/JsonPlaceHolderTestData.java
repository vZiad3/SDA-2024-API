package testdata;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    protected RequestSpecification spec;
    @BeforeMethod
    public void setUo(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }

    public static Map<String,Object> jsonPlaceHolderMapper(Integer userId , String titel , Boolean completed){
        Map<String, Object> payLoad = new HashMap<>();
        if (userId!=null){
            payLoad.put("userId",userId);
        }
        if (titel!=null){
            payLoad.put("title",titel);
        }
        if (completed!=null){
            payLoad.put("completed",completed);
        }
        return payLoad;
    }
}