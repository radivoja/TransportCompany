package com.qinshift.transportCompany.wiremock;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@WireMockTest
public class WiremockIntegrationTest {
    private WireMockServer wireMockServer;

    @BeforeEach
    public void setup() {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8089));
        wireMockServer.start();
        WireMock.configureFor("localhost", 8089);
    }

    @AfterEach
    public void teardown() {
        wireMockServer.stop();
    }

    @Test
    public void wiremockTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8089/apiFirst/wiremockTest", String.class);

        String responseBody = "[{\"id\":1,\"name\":\"FedEx\",\"location\":\"Memphis, TN\",\"founded\":1971},{\"id\":2,\"name\":\"UPS (United Parcel Service)\",\"location\":\"Atlanta, GA\",\"founded\":1907},{\"id\":3,\"name\":\"DHL Express\",\"location\":\"Plantation, FL\",\"founded\":1969}]";
        assertThat(response.getStatusCodeValue(), equalTo(200));
        assertThat(response.getBody(), equalTo(responseBody));
        verify(getRequestedFor(urlPathMatching("/apiFirst/wiremockTest")));
    }

    @Test
    public void getAllCompanies(){
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8089/apiFirst/wiremockList", String.class);
        assertThat(response.getStatusCodeValue(), equalTo(418));
        assertThat(response.getHeaders().getContentType(), equalTo(MediaType.APPLICATION_JSON));
        verify(getRequestedFor(urlPathMatching("/apiFirst/wiremockList")));
    }

}


