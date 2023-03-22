package com.microcare.springbootmicrocare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class SpringbootMicrocareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicrocareApplication.class, args);
	}

}
