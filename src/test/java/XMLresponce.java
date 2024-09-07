import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pack.student;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class XMLresponce {


    @Test
    void testXMLResponce(){
        Response res=given()
        .when()
                .get("https://dummy.restapiexample.com/api/v1/employee/1");
//        .then()
//                .statusCode(200)
//                .log().all();

        String name=res.jsonPath().get("data").toString();

        System.out.println(name);

    }

    @Test
    void pojoToJson(){
        student stuObj= new student();
        stuObj.setName("kk");
        stuObj.setJob("apitester");
        stuObj.setLocation("gnt");
        stuObj.setEducation("diploma");


        given()
//                .contentType("application/json")
//                .body(stuObj)
        .when()
                .get("http://localhost:3000/members")
        .then()
                .statusCode(200)
                .log().all();
    }
}
