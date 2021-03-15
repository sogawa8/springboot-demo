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

}
