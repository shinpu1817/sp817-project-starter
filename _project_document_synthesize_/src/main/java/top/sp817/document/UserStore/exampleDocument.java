package top.sp817.document.UserStore;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import top.sp817.source.userstore.exampleService;


@Component
@RequestMapping("${prefix.UserStore}")
public class exampleDocument implements exampleService {

    @Override
    public String hello() {
        return "";
    }

    @Override
    public String test() {
        return "";
    }

    @Override
    public String login() {
        return "";
    }

    @Override
    public String logout() {
        return "";
    }
}