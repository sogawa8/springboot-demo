package jp.co.demo.application;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import jp.co.demo.domain.DemoEntity;
import jp.co.demo.domain.DemoEntityRepository;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class DemoScenario {

    private final DemoEntityRepository demoEntityRepository;

    public String getHoge() {
        return "Hoge from application layer";
    }

    public List<DemoEntity> getAllDemoEntity() {
        return demoEntityRepository.findAll();
    }

    public void saveDemo(long id) {
        DemoEntity demoEntity = new DemoEntity(id, "demo" + id);
        demoEntityRepository.save(demoEntity);
    }

    boolean demoTest1() {
        return true;
    }

    List<String> demoTest2() {
        return List.of("a", "b", "c");
    }

    List<DemoEntity> demoTest3() {
        return List.of(new DemoEntity(1L, "demo1"), new DemoEntity(2L, "demo2"));
    }

    DemoEntity demoTest4() {
        return new DemoEntity(1L, "demo1");
    }
}
