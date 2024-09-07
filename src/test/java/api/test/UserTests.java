package api.test;

import api.endpoints.userEndPoint;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static groovy.util.Eval.x;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserTests {

    Faker faker;
    User userPayload;
    @BeforeClass
    public void setupData(){
        faker=new Faker();
        userPayload=new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());

    }

//    @Test(priority = 1)
//    public void testPostUser(){
//        Response response=userEndPoint.createUser(userPayload);
//        response.then().log().all();
//
//        Assert.assertEquals(response.getStatusCode(),201);
//    }

    @Test
    public void testGetUserByName(){
        Response response=userEndPoint.readUser();

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);


    }


    @Test
    public void jspath(){
        var res=given()
                .when()
                .get("http://localhost:3000/raceBet(1)")
                .then()
                .extract()
                .body();

        var lst= res.jsonPath().;


        System.out.println(lst);
    }
}
