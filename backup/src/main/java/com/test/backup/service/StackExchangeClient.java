package com.test.backup.service;

import com.test.backup.domain.DTOUser;
import com.test.backup.domain.entity.ToDo;
import com.test.backup.model.ToDos;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Logger;

@Component
public class StackExchangeClient {
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);
    public static final Logger logger = Logger.getLogger(StackExchangeClient.class.getName());

    public List<DTOUser> getUsers(String url){
        ResponseEntity<List<DTOUser>> listResponseEntity = null;
        try {
            listResponseEntity = restTemplate.exchange(new URI(url),
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<DTOUser>>() {
                    });
        } catch (URISyntaxException e) {
            logger.warning(String.valueOf(e));
        }
        List<DTOUser> response = listResponseEntity.getBody();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public List<ToDo> getToDo(){
        String url = "http://localhost:9000";
        ToDos response = null;
        try {
            response = restTemplate.getForObject(new URI(url), ToDos.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return response.getItems();
    }
}
