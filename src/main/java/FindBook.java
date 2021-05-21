import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FindBook {
    public Response getBook(String queryName, String queryString) {
        Response response = given()
                .header("Content-type", "application/json")
                .param(queryName, queryString)
                .when()
                .get("/Library/GetBook.php")
                .then()
                .extract().response();
        return response;
    }
}
