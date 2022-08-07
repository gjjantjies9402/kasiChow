package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class KasiChowApplication {
    public static void main(String[] args) {
        SpringApplication.run(KasiChowApplication.class, args);
    }
}
