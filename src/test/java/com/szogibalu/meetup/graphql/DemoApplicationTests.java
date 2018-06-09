package com.szogibalu.meetup.graphql;

import com.fasterxml.jackson.databind.JsonNode;
import com.szogibalu.meetup.graphql.util.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DemoApplicationTests {

    public static final String URL = "/graphql";

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    TestUtils graphQLTestUtils;

    @Autowired
    ApplicationContext applicationContext;

    @Value("classpath:graphql/bookQuery.graphql")
    Resource bookQueryString;

    @Test
    public void testApplicationContext() {
        assertThat(applicationContext).isNotNull();
    }


    @Test
    public void test() {
        ResponseEntity<String> response = postRequest(graphQLTestUtils.createJsonQuery(bookQueryString));

        assertEquals(OK, response.getStatusCode());

        JsonNode parsedResponse = graphQLTestUtils.parse(response.getBody());
        assertNotNull(parsedResponse);

        JsonNode firstBook = parsedResponse.get("data").get("books").get(0);
        assertThat(firstBook.get("name").asText()).isEqualTo("The Lord of the Rings");
        assertThat(firstBook.get("author").get("name").asText()).isEqualTo("J.R. Tolkien");
    }

    private ResponseEntity<String> postRequest(String payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON_VALUE);

        HttpEntity<String> httpEntity = new HttpEntity<>(payload, headers);
        return restTemplate.exchange(URL, POST, httpEntity, String.class);
    }

}