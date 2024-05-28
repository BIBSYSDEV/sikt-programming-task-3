package no.sikt.person;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class PersonService {

    private final HttpClient httpClient;

    public PersonService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String fetch(URI uri) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                          .GET()
                          .header("Accept", "application/json")
                          .uri(uri)
                          .build();
        return httpClient.send(request, BodyHandlers.ofString()).body();
    }
}
