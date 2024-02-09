package com.kamilacodestore.msproduto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class MsProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProdutoApplication.class, args);
	}

}
