import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AddBook {
    public Response addNewBook(String body) {
        Response response = given()
                .header("Content-type", "application/json")
                .body(body)
                .and()
                .post("/Library/Addbook.php")
                .then()
                .extract().response();
        return response;
    }
}
