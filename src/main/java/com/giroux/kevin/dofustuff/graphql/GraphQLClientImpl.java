package com.giroux.kevin.dofustuff.graphql;

import com.giroux.kevin.dofustuff.commons.security.RefreshToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class GraphQLClientImpl implements GraphQLClient {

    @Value("${graphql.host}")
    private String host;

    @Value("${graphql.port}")
    private String port;

    @Value("${graphql.path}")
    private String path;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public RefreshToken executeGet(String query) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>("parameters",headers);
        ResponseEntity<RefreshToken> responseEntity = restTemplate.exchange(host + port + path, HttpMethod.POST,httpEntity,RefreshToken.class);

        return responseEntity.getBody();
    }
}
