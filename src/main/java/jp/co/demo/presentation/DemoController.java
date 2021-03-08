package jp.co.demo.presentation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.demo.application.DemoScenario;

@Controller
public class DemoController {

    @Autowired
    private DemoScenario demoScenario;

    @RequestMapping("/get/hoge")
    public String getHoge(Model model) {
        model.addAttribute("hoge", "HOGE");
        return "hoge";
    }

    @RequestMapping("/get/form")
    public String getForm(Model model) {
        DemoForm demoForm = new DemoForm(1L, "hoge");
        model.addAttribute("demoForm", demoForm);
        return "demo";
    }

    @RequestMapping("/get/forms")
    public String getForms(Model model) {
        List<DemoForm> demoForms = List.of(new DemoForm(1L, "hoge"));
        model.addAttribute("demoForms", demoForms);
        return "demo_list";
    }

    @RequestMapping("/get/forms/from/db")
    public String getAllDemoEntity(Model model) {
        List<DemoForm> demoForms = demoScenario.getAllDemoEntity()
                                               .stream()
                                               .map(entity -> new DemoForm(entity.getDemoId(), entity.getDemoString()))
                                               .collect(Collectors.toList());
        model.addAttribute("demoForms", demoForms);
        return "demo_list";
    }
}
