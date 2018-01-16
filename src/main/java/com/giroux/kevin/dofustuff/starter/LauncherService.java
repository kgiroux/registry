package com.giroux.kevin.dofustuff.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan({"com.giroux.kevin.dofustuff"})
public class LauncherService {

	public static void main(String... args) {
		SpringApplication.run(LauncherService.class, args);		
	}
}
