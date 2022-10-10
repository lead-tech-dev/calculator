package com.leszko.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.hazelcast.client.config.ClientConfig;

@SpringBootApplication
@EnableCaching
public class CalculatorApplication {
	
	private static final String CONSTANT = "constant";

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}
	
    @Bean
    public ClientConfig hazelcastClientConfig() {
    	
    	ClientConfig clientConfig = new ClientConfig();
    	clientConfig.getNetworkConfig().getAwsConfig();
    	clientConfig.getNetworkConfig().addAddress("hazelcast");
    	//clientConfig.getNetworkConfig().addAddress("44.204.90.148");
    	
    	return clientConfig;
    }

}
