package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

@JsonIgnoreProperties(ignoreUnknown = true)                         //////// ignore extra fields
public class JsonPlaceHolderPojo {
    //Create private variables for each field
    protected RequestSpecification spec;
    @BeforeMethod
    public void setUo(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();
    }
    private Integer userId ;
    private String title ;
    private Boolean completed ;

  // {
  //     "userId": 55,
  //         "title": "Tidy your room",
  //         "completed": false
  // }
    //Create constructors with parameters and without parameters

    public JsonPlaceHolderPojo() {
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    //Create Getters and Setters

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }



    //Create ToString


    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
