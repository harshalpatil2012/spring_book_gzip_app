
package com.example.bookapp;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }


    @Value("${server.compression.enabled}")
    private boolean compressionEnabled;

    @Value("${server.compression.min-response-size}")
    private int minResponseSize;


    @PostConstruct
    public void logCompressionSettings() {
        System.out.println("Compression Enabled: " + compressionEnabled);
        System.out.println("Minimum Response Size for Compression: " + minResponseSize);
    }
}
