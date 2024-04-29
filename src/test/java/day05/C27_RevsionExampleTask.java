package day05;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C27_RevsionExampleTask extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Abhaidev Kaur", "Fr. Deenabandhu Adiga", "Akshita Singh DC" are among the users -> Data may change
        And
            The female users are less than or equals to male users -> Data may change
*/

    @Test
    public void task(){

        spec.pathParam("first","users");
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        Object limit = jsonPath.getInt("meta.pagination.limit");    // we need int so we use getInt
        Object current = jsonPath.getString("meta.pagination.links.current");    // we need int so we use getInt
        System.out.println("current = " + current);

       Object users = jsonPath.getList("data.names").size();
       System.out.println("users = " + users);

        int status = jsonPath.getList("data.findAll{it.status=='active'}").size();    // we need string so we use getInt
        System.out.println("status = " + status);
        int female = jsonPath.getList("data.findAll{it.gender=='female'}").size();    // we need string so we use getInt
        int male = jsonPath.getList("data.findAll{it.gender=='male'}").size();    // we need string so we use getInt
        System.out.println("male = " + male);
        System.out.println("female = " + female);


        //Do assetion
        //user
        Assert.assertEquals(users,10);
        //current link
        Assert.assertTrue(current.equals("https://gorest.co.in/public/v1/users?page=1"));
        //limit
        Assert.assertEquals(limit,10);

        Assert.assertTrue(status > 1);      // it should be int line 47 so i can assert , Object is not working
        Assert.assertTrue(female > male);


    }
}
