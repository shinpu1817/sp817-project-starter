package top.sp817;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KnifeStart {
    public static void main(String[] args) {
        SpringApplication.run(KnifeStart.class, args);
        System.out.println("http://localhost:9097/doc.html#/home");
    }
}