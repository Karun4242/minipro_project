package api.endpoints;

import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import api.payload.User;
public class userEndPoint {


    public static Response createUser(User payload){
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
        .when()
                .post(Routes.post_url);

        return response;
    }

    public static Response readUser(){

        Response response=given()

        .when()
                .get(Routes.get_url);

        return response;
    }

    public static Response updateUser(int id, User payload){
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .param("id",id)
                .body(payload)

        .when()
                .put(Routes.update_url);

        return response;
    }

    public static Response deleteUser(int id, User payload){
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

        .when()
                .delete(Routes.delete_url);

        return response;
    }


}
