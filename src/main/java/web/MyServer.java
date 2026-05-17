package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "web")
public class MyServer {

    public static void main(String[] args) {
        SpringApplication.run(MyServer.class, args);
    }
}
