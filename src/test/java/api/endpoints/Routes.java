package api.endpoints;


/*swagger URI ---> https://petstore.swagger.io/
create user(post)-->https://petstore.swagger.io/#/user
get user (Get)---> https://petstore.swagger.io/#/user/getUserByName

update user (PUT)--->https://petstore.swagger.io/#/user/updateUser
delete user(Delete)--->https://petstore.swagger.io/#/user/deleteUser

*/
public class Routes {

    public static String base_url="http://localhost:3000/";

    // user module
    public static String post_url="http://localhost:3000/0";
    public static String get_url="http://localhost:3000/10";
    public static String update_url=base_url+"id";
    public static String delete_url=base_url+"id";


    //store module


    //pet module


}
