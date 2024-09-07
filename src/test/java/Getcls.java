import io.restassured.common.mapper.TypeRef;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.sql.Ref;
import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import com.google.gson.JsonObject;


public class Getcls {

    @Test
    public void filter(){
        List<Map<String, Object >> posts=given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .extract()
                .body()
                .as(new TypeRef<List<Map<String, Object>>>() {});

        List<Map<String, Object >>filterpost=posts.stream().filter(post->post.get("userId").equals(1)).collect(Collectors.toList());
        Assert.assertTrue(filterpost.stream().allMatch(post->post.get("userId").equals(1)));
    }

    @Test
    public void extract(){
        List<Map<String, Object >> coments=given()
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .extract()
                .body()
                .as(new TypeRef<List<Map<String, Object>>>() {});

        List<String> email=coments.stream().map(comment->(String)comment.get("email")).collect(Collectors.toList());
        Assert.assertFalse(email.isEmpty());
        System.out.println(email);
    }
    @Test
    public void calculate(){
        List<Map<String, Object >> cmt=given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .extract()
                .body()
                .as(new TypeRef<List<Map<String, Object>>>() {});

        int sumOfUserId =cmt.stream().mapToInt(pst->(Integer)pst.get("userId")).sum();
        Assert.assertTrue(sumOfUserId>0);
        System.out.println(sumOfUserId);
    }

    @Test
    public void specficElement(){
        List<Map<String, Object >> users=given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .extract()
                .body()
                .as(new TypeRef<List<Map<String, Object>>>() {});

        Optional<Map<String, Object>> user =users.stream().filter(u->u.get("username").equals("Bret")).findFirst();
        Assert.assertTrue(user.isPresent());
        System.out.println(user);

    }

    @Test
    public void checkedAllElements(){
        List<Map<String, Object >> elemets=given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .extract()
                .body()
                .as(new TypeRef<List<Map<String, Object>>>() {});

        boolean ele =elemets.stream().allMatch(u->u.get("title")!=null);
        Assert.assertTrue(ele);
        System.out.println(ele);
    }

    @Test
    public void localhost(){
        var res=given()
                .when()
                .get("https://jsonplaceholder.typicode.com/comments");

        var lst= res.getBody().jsonPath().get("postId");
//        var hhs=res.getBody().getJsonObject("postId");



        System.out.println(lst);
    }



















    @Test
    public void mapres() {
        List<Map<String, Object>> id = given()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .extract()
                .body()
                .as(new TypeRef<List<Map<String, Object>>>() {
                });

        var lst= id.stream()
                .filter(nms->nms.get("id").equals(14)).findFirst();
//                .filter(k->k.get("title").equals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")).toString();

//        String nms= lst.stream().filter(x->x.get("title").equals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")).toString();

//        Assert.assertEquals(lst,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
//       String nss=lst.stream().filter(x->x.get("title").equals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")).toString();

        System.out.println(lst);

    }
}
