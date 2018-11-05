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
        ResponseEntity<List<DTOUser>> rateResponse = null;
        try {
            rateResponse = restTemplate.exchange(new URI(url),
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<DTOUser>>() {
                    });
        } catch (URISyntaxException e) {
            logger.warning(String.valueOf(e));
        }
        List<DTOUser> response = rateResponse.getBody();
        //String tr = response.get(0).getEmail();
        //DTOUser responseEntity = restTemplate.getForObject("http://localhost:9000/users/1", DTOUser.class);
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    public List<ToDo> getToDo(){
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        messageConverters.add(converter);
//        restTemplate.setMessageConverters(messageConverters);
        //responseEntity = responseEntity.substring("[".length(),responseEntity.length()-"]".length());
        //String go = responseEntity.substring(1,63);

        //        Type type = new TypeToken<List<DTOUser>>(){}.getType();
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .disableHtmlEscaping()
//                .create();
//        List<DTOUser> reponse = gson.fromJson(responseEntity, type);
        String url = "http://localhost:9000";
        ToDos response = null;
        try {
            response = restTemplate.getForObject(new URI(url), ToDos.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //return Arrays.asList(response.getBody());
        return response.getItems();
    }
}
