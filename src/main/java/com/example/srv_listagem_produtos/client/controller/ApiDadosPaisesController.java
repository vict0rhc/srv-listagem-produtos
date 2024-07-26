package com.example.srv_listagem_produtos.client.controller;

import com.example.srv_listagem_produtos.client.model.ResponseApiDadosPaises;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("rest-countries")
public class ApiDadosPaisesController {
    @GetMapping("{pais}")
    public ResponseApiDadosPaises[] consultaApiDadosPaises(@PathVariable("pais")String pais){
        String url = "https://restcountries.com/v3.1/translation/" + pais;
        RestTemplate restTemplate = new RestTemplate();
        ResponseApiDadosPaises[] responseApiDadosPaises = restTemplate.getForObject(url, ResponseApiDadosPaises[].class);
        return responseApiDadosPaises;
    }

}
