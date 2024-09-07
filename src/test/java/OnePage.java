import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v125.fetch.model.AuthChallengeResponse;
import org.testng.annotations.Test;
import pack.Pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;
import static org.hamcrest.Matchers.*;


public class OnePage {


    @Test
    public void createUser() {

        Pojo pojoObj = new Pojo();

        pojoObj.setName("kumar");
        pojoObj.setLocation("hyd");
        pojoObj.setEducation("b.tech");
        pojoObj.setJob("tester");


        given()
                .contentType("application/json")
                .body(pojoObj)
                .when()
                .put("http://localhost:3000/store")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void queryParam() {
        given()
                .pathParam("mypath", "users")
                .queryParam("page", 3)
                .queryParam("id", 3)
                .when()
                .get("https://reqres.in/api/{mypath}")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    void getCookies() {
        Response res = given()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employee/1");


        String cookies = res.getCookie("AEC");
        System.out.println(cookies);

//        Map<String, String> values = res.getCookies();
//
//        System.out.println(values.keySet());
//        JSONObject requestParams = new JSONObject(res);


    }

    @Test
    void getlimit() {
       Response res=given()
        .when()
               .get("https://jsonplaceholder.typicode.com/posts");
//        .then()
//                .log().all();



        List <Object> name=res.jsonPath().getList("id").stream().limit(5).collect(Collectors.toList());
        System.out.println(name);
    }


    @Test
    void getres() {
        Response res = given()
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available");


        List <Object> name=res.jsonPath().getList("name").stream().filter(x->x.toString().length()>5).sorted().collect(Collectors.toList());
        System.out.println(name);


    }


    @Test
    void getpet() {
        Response res = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts");


        var name=res.jsonPath().getList("title").stream().filter(x->x.toString().length()>15).limit(5).collect(Collectors.toList());
        System.out.println(name);


    }
    @Test
    void postlocal() {

        Pojo pojoObj=new Pojo();
        pojoObj.setName("karun");
        pojoObj.setJob("automation");
        pojoObj.setLocation("hyd");
        Response res = given()

                .contentType("application/json")
                .body(pojoObj.toString())
        .when()
                .post("http://localhost:3000/3");

        System.out.println(res.statusCode());
        System.out.println(res.getBody().toString());



    }


}



