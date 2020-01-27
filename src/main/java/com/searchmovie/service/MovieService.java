package com.searchmovie.service;

import com.searchmovie.model.MovieModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    public String url = "https://www.omdbapi.com/?apikey=e0fdc28c&i=tt8579674";
    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> GetJsonObject() {

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        // Make the HTTP GET request, marshaling the response to a String
        ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        System.out.println("result:" + res);
        return res;
    }

    public MovieModel getAll(String type, String query) {

        String url = "https://www.omdbapi.com/?apikey=e0fdc28c&" + type + "=" + query;

        return this.restTemplate.exchange(url, HttpMethod.GET, null, MovieModel.class).getBody();


    }

}

