package no.sikt.person;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * A naïve mock server that returns 200 OK and the body when any URI is passed to it.
 */
public class MockServer {

    /**
     * Returns an HttpClient that will respond 200 OK for the given URI and return the given body.
     * @param uri The URI to match
     * @param body The body to return
     * @return The mocked HttpClient
     */
    public static HttpClient setUpMockHttpClient(URI uri, String body) {
        var httpClient = mock(HttpClient.class);
        var httpResponse = mockHttpResponse(body);
        try {
            when(httpClient.send(createHttpRequest(uri), BodyHandlers.ofString())).thenReturn(httpResponse);
        } catch (IOException e) {
            throw new RuntimeException("There is an issue with mocking");
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted exception that shouldn't happen");
        }
        return httpClient;
    }

    private static HttpRequest createHttpRequest(URI uri) {
        return HttpRequest.newBuilder()
                   .GET()
                   .headers("Accept", "application/json")
                   .uri(uri)
                   .build();
    }

    private static HttpResponse<String> mockHttpResponse(String body) {
        var httpResponse = mock(HttpResponse.class);
        when(httpResponse.statusCode()).thenReturn(200);
        when(httpResponse.body()).thenReturn(body);
        return httpResponse;
    }
}
