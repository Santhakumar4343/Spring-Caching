package com.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachingSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingSbApplication.class, args);
	}

}
