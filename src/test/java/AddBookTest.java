import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddBookTest extends BaseTest {
    @BeforeTest
    public void setup() {
        InitialSetup();
    }

    @Test
    public void testAddNewBook() {
        AddBook book = new AddBook();
        Response response = book.addNewBook(getRequestBody());
        assertEquals(200, response.statusCode());
        assertEquals("successfully added", response.jsonPath().getString("Msg"));
    }

    @Test
    public void testAddAlreadyExistingBook() {
        AddBook book = new AddBook();
        Response response = book.addNewBook(getRequestBody());
        assertEquals(404, response.statusCode());
        assertEquals("Add Book operation failed, looks like the book already exists", response.jsonPath().getString("msg"));
    }
}
