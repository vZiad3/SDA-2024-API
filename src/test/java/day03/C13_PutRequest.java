package day03;

import org.testng.annotations.Test;
import testdata.JsonPlaceHolderTestData;

import java.util.Map;

public class C13_PutRequest extends JsonPlaceHolderTestData {
    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "userId": 21,
             "title": "Read Books",
             "completed": false
           }
    When
        I send a PUT request to the URL
    Then
       the status code should be 200
       And the response body should be like:
       {
          "completed": false,
          "title": "Read Books",
          "userId": 21,
          "id": 198
       }

     */
    @Test
    public void dd(){
        spec.pathParams("first","todos"
                            ,"second",189   ) ;

        Map<String,Object> payLoad =  jsonPlaceHolderMapper(21,"Read Books",false);
    }
}
