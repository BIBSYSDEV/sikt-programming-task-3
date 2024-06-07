package no.sikt.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    public static final URI PERSON_URI = URI.create("https://example.org/person/1");

    public static final String PERSON_BODY = """
        {
          "id": "1",
          "name": "Smith, Sandy",
          "dob": "1992-03-07"
        }
        """;

    private HttpClient httpClient;

    @BeforeEach
    void setUp() {
        this.httpClient = MockServer.setUpMockHttpClient(PERSON_URI, PERSON_BODY);
    }

    @Test
    void shouldReturnTheServiceDataDirectly() throws IOException, InterruptedException {
        var service = new PersonService(httpClient);
        assertEquals(PERSON_BODY, service.fetch(PERSON_URI));
    }

    @Test
    void shouldReturnUriAsIdFieldWhenUriIsRequested() {
        fail();
    }

    @Test
    void shouldReturnTypeFieldWithValuePersonWhenUriIsRequested() {
        fail();
    }

    @Test
    void shouldReturnNameObjectFieldWhenUriIsRequested() {
        fail();
    }

    @Test
    void shouldReturnAgeFieldWhenUriIsRequested() {
        fail();
    }
}
