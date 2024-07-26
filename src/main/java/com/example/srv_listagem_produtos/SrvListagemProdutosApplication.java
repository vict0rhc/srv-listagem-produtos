package com.example.srv_listagem_produtos;

import com.example.srv_listagem_produtos.client.controller.ApiDadosPaisesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SrvListagemProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrvListagemProdutosApplication.class, args);
	}

}
