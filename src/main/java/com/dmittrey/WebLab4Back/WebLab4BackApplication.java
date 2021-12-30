package com.dmittrey.WebLab4Back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebLab4BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebLab4BackApplication.class, args);
	}


	//todo Перевод в entities
	// Логику обработки и высчитывания полей в сервисе
	// Логику работы с бд в репозитории
	// Донастроить security

	//ssh -L 1521:se.ifmo.ru:1521 -p 2222 s312502@se.ifmo.ru

}
