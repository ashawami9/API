import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class FindBookTest extends BaseTest {
    @BeforeTest
    public void setup() {
        InitialSetup();
    }

    @Test
    public void testFindBookById() {
        AddBook newBook = new AddBook();
        String id = newBook.addNewBook(getRequestBody()).jsonPath().getString("ID");
        FindBook book = new FindBook();
        Response response = book.getBook("ID", id);
        assertEquals(200, response.statusCode());
        assertEquals("Learn Appium Automation with Java", response.jsonPath().getString("book_name[0]"));
    }

    @Test
    public void testFindBookByAuthorName() {
        FindBook book = new FindBook();
        Response response = book.getBook("AuthorName", getAuthor());
        assertEquals(200, response.statusCode());
        assertEquals("Joy", response.jsonPath().getString("book_name[0]"));
    }
}
