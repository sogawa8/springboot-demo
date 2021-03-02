package jp.co.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.demo.application.DemoScenario;

@RestController
public class DemoRestController {

    @Autowired
    private DemoScenario demoScenario;

    @RequestMapping("/get/hoge")
    public String getHoge() {
        return "Hoge";
    }

    @RequestMapping("/get/hoge/from/app")
    public String getHogeFromApplicationLayer() {
        return demoScenario.getHoge();
    }

}
