package jp.co.demo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.demo.application.DemoScenario;
import jp.co.demo.domain.DemoEntity;

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

    @RequestMapping("/get/hoge/from/db")
    public List<DemoEntity> getAllDemoEntity() {
        return demoScenario.getAllDemoEntity();
    }

    @RequestMapping("/put/{id}")
    public String putDemo(@PathVariable long id) {
        demoScenario.saveDemo(id);
        return "demo" + id + "を登録しました。";
    }

}
