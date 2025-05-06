package top.sp817.source.userstore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface exampleService {

    @GetMapping("/demo/hello")
    String hello();

    @PostMapping("/demo/test")
    String test();

    @GetMapping("/demo/login")
    String login();

    @GetMapping("/demo/logout")
    String logout();

}