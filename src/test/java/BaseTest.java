import io.restassured.RestAssured;

public class BaseTest {
    private String author = "cloe";
    private String requestBody = "{\n" +
            "    \"name\" : \"Use Mac\",\n" +
            "    \"isbn\" : \"299392110123\",\n" +
            "    \"aisle\": \"1291919\",\n" +
            "    \"author\": \"siri\"\n" +
            "}";

    public void InitialSetup() {
        RestAssured.baseURI = "http://216.10.245.166";
    }

    public String getAuthor() {
        return author;
    }

    public String getRequestBody() {
        return requestBody;
    }
}
