package jp.co.demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/get/hoge")
    public String getHoge(Model model) {
        model.addAttribute("hoge", "HOGE");
        return "hoge";
    }

}
