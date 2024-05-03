package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static utilities.AuthenticationRestful.getToken;

public class RestFullBaseUrl {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setUo(){
         spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                 .addHeader("Cookie","token=" + getToken())
                 .setContentType(ContentType.JSON)
                .build();
    }
}
