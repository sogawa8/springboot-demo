package jp.co.demo.application;

import org.springframework.stereotype.Service;

@Service
public class DemoScenario {

    public String getHoge() {
        return "Hoge from application layer";
    }

}
