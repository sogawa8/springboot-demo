package jp.co.demo.application;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.demo.domain.DemoEntity;
import jp.co.demo.domain.DemoEntityRepository;

@Transactional
@Service
public class DemoScenario {

    @Autowired
    private DemoEntityRepository demoEntityRepository;

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
