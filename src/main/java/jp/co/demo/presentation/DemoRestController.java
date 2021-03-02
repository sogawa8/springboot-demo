package jp.co.demo.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @RequestMapping("/get/hoge")
    public String getHoge() {
        return "Hoge";
    }
}
